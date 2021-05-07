package com.prvz.urlchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UrlsRepository {

    public static final String INSERT_SQL = "INSERT INTO urls (url, periodMinutes, nextCheckAt) VALUES (?, ?, ?)";
    public static final String SELECT_ALL_SQL = "SELECT * FROM urls ORDER BY created_at DESC FETCH FIRST ? ROWS ONLY";
    public static final String SELECT_BY_NEXT_CHECK_AT_BEFORE = "SELECT * FROM urls WHERE nextCheckAt < ? ORDER BY nextCheckAt ASC";
    private static final Logger logger = LoggerFactory.getLogger(UrlsRepository.class);
    private final DataSource dataSource;

    public UrlsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<AddUrlResponse> findAllByNextCheckAtBefore(OffsetDateTime nextCheckAtBefore) {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_NEXT_CHECK_AT_BEFORE);
        ) {

            statement.setObject(1, nextCheckAtBefore);
            ResultSet rs = statement.executeQuery();
            return resultSetToResponseList(rs);

        } catch (SQLException sqlEx) {
            return null;
        }
    }

    public List<AddUrlResponse> findAllOrderedByCreatedAt(int limit) {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
        ) {

            statement.setInt(1, limit);
            ResultSet rs = statement.executeQuery();
            return resultSetToResponseList(rs);

        } catch (SQLException sqlEx) {
            return null;
        }
    }

    public boolean addUrl(AddUrlRequest request) {

        URL url;
        try {
            url = new URL(request.url);
        } catch (IllegalArgumentException iae) {
            logger.error("Cannot parse url", iae);
            return false;
        } catch (MalformedURLException e) {
            logger.error("Incorrect url", e);
            return false;
        }

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
        ) {

            int parameterIndex = 1;

            statement.setString(parameterIndex++, url.getHost() + url.getPath());
            statement.setInt(parameterIndex++, request.periodMinutes);

            OffsetDateTime nextCheckAt;
            if (request.nextCheckAt != null) {
                nextCheckAt = request.nextCheckAt;
            } else {
                nextCheckAt = OffsetDateTime.now().plusMinutes(request.periodMinutes);
            }
            statement.setObject(parameterIndex++, nextCheckAt);

            int updated = statement.executeUpdate();

            if (updated != 1) {
                logger.error("Incorrect insert result. Updated is {}", updated);
                return false;
            }

        } catch (SQLException sqlEx) {
            logger.error("Cannot add new url.", sqlEx);
            return false;
        }
        return true;
    }

    private List<AddUrlResponse> resultSetToResponseList(ResultSet rs) throws SQLException {

        if (rs.getFetchSize() == 0) {
            return Collections.emptyList();
        }

        List<AddUrlResponse> result = new ArrayList<>();

        while (rs.next()) {
            int parameterIndex = 1;
            String url = rs.getString(parameterIndex++);
            Integer periodMinutes = rs.getInt(parameterIndex++);
            OffsetDateTime nextCheckAt = rs.getObject(parameterIndex++, OffsetDateTime.class);
            AddUrlResponse response = new AddUrlResponse(
                url,
                periodMinutes,
                nextCheckAt
            );
            result.add(response);
        }

        return result;
    }
}

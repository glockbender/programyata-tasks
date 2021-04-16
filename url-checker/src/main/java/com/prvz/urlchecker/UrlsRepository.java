package com.prvz.urlchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.OffsetDateTime;

public class UrlsRepository {

    private static final Logger logger = LoggerFactory.getLogger(UrlsRepository.class);

    private final DataSource dataSource;

    public UrlsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean addUrl(AddUrlRequest request) {

        URI uri;
        try {
            uri = URI.create(request.url);
        } catch (IllegalArgumentException iae) {
            logger.error("Cannot parse url", iae);
            return false;
        }

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO urls (url, periodMinutes, startAt) VALUES (?, ?, ?)");
        ) {

            int parameterIndex = 1;

            statement.setString(parameterIndex++, uri.getHost() + uri.getPath());
            statement.setInt(parameterIndex++, request.periodMinutes);

            OffsetDateTime startAt;
            if (request.startAt != null) {
                startAt = request.startAt;
            } else {
                startAt = OffsetDateTime.now().plusSeconds(60);
            }
            statement.setObject(parameterIndex++, startAt);

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
}

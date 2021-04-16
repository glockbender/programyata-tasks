package com.prvz.urlchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

public class UrlsRepository {

    private static final Logger logger = LoggerFactory.getLogger(UrlsRepository.class);

    private final DataSource dataSource;

    public UrlsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AddUrlResponse addUrl(AddUrlRequest request) {

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO urls (id, url) VALUES (?, ?)");
        ) {
            statement.setObject(1, UUID.randomUUID(), Types.OTHER);
            statement.setString(2, request.url);
            int updated = statement.executeUpdate();

            if (updated != 1) {
                logger.error("Incorrect insert result. Updated is {}", updated);
                return null;
            }

            return new AddUrlResponse(request.url, "");

        } catch (SQLException sqlEx) {
            logger.error("Cannot add new url.", sqlEx);
            return null;
        }
    }
}

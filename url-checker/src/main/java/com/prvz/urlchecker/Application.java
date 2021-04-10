package com.prvz.urlchecker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.flywaydb.core.api.output.MigrateResult;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import javax.sql.DataSource;

public class Application {

    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().findAndRegisterModules();
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Spark.initExceptionHandler((e) -> {
            logger.error("Initialization failed", e);
            System.exit(100);
        });
        Spark.port(8080);

        AppProperties appProperties = AppProperties.build();

        HikariConfig dbConfig = new HikariConfig();
        dbConfig.setJdbcUrl(appProperties.db.url);
        dbConfig.setUsername(appProperties.db.user);
        dbConfig.setPassword(appProperties.db.password);
        dbConfig.setDriverClassName("org.postgresql.Driver");

        HikariDataSource dataSource = new HikariDataSource(dbConfig);

        FluentConfiguration flywayConfig = new FluentConfiguration()
            .dataSource(dataSource)
            .locations(new Location("db/migration/V1__init.sql"));

        MigrateResult migrateResult = new Flyway(flywayConfig).migrate();

        Spark.init();

        Spark.awaitInitialization();

        Spark.path("/api/v1/urls", () -> {

            Spark.post("/", "application/json", (req, res) -> {
                AddUrlRequest request = OBJECT_MAPPER.readValue(req.body(), AddUrlRequest.class);
                AddUrlResponse response = new AddUrlResponse("", "");
                return OBJECT_MAPPER.writeValueAsString(response);
            });

        });

    }

}

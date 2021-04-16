package com.prvz.urlchecker;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.flywaydb.core.api.output.MigrateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private AppProperties appProperties;
    private DataSource dataSource;

    private AppConfig() {
    }

    public static AppConfig buildConfig() {

        AppProperties appProperties = AppProperties.build();

        HikariConfig dbConfig = new HikariConfig();
        dbConfig.setJdbcUrl(appProperties.db.url);
        dbConfig.setUsername(appProperties.db.user);
        dbConfig.setPassword(appProperties.db.password);
        dbConfig.setDriverClassName("org.postgresql.Driver");

        HikariDataSource dataSource = new HikariDataSource(dbConfig);

        FluentConfiguration flywayConfig = new FluentConfiguration()
            .dataSource(dataSource)
            .locations(new Location("db/migration"));

        MigrateResult migrateResult = new Flyway(flywayConfig).migrate();

        logger.info("Migrate result: {}", migrateResult);

        AppConfig result = new AppConfig();
        result.appProperties = appProperties;
        result.dataSource = dataSource;

        return result;
    }

    public AppProperties getAppProperties() {
        return appProperties;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

}

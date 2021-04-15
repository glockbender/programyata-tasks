package com.prvz.urlchecker;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class AppConfig {

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

//        FluentConfiguration flywayConfig = new FluentConfiguration()
//            .dataSource(dataSource)
//            .locations(new Location("db/migration"));
//
//        MigrateResult migrateResult = new Flyway(flywayConfig).migrate();

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

package com.prvz.urlchecker;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class AppProperties {

    public final Db db;
    public final Checker checker;

    private AppProperties(Db db, Checker checker) {
        this.db = db;
        this.checker = checker;
    }

    public static AppProperties build() {

        File propertiesFile = new File("application.properties");

        Configurations configs = new Configurations();
        try {
            PropertiesConfiguration configuration = configs.properties(propertiesFile);

            String dbUser = configuration.getString("db.user");
            String dbPassword = configuration.getString("db.password");
            String dbUrl = configuration.getString("db.url");

            Db db = new Db(
                dbUser,
                dbPassword,
                dbUrl
            );

            int startDelaySeconds = configuration.getInteger("checker.startDelaySeconds", 10);
            int periodSeconds = configuration.getInteger("checker.periodSeconds", 10);

            Checker checker = new Checker(startDelaySeconds, periodSeconds);

            return new AppProperties(db, checker);

        } catch (ConfigurationException e) {
            throw new RuntimeException("Cannot initialize configuration", e);
        }


    }

    static class Db {
        public final String user;
        public final String password;
        public final String url;

        Db(String user, String password, String url) {
            this.user = user;
            this.password = password;
            this.url = url;
        }

    }

    static class Checker {
        public final int startDelaySeconds;
        public final int periodSeconds;

        Checker(int startDelaySeconds, int periodSeconds) {
            this.startDelaySeconds = startDelaySeconds;
            this.periodSeconds = periodSeconds;
        }
    }

}

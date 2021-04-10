package com.prvz.urlchecker;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class AppProperties {

    public final Db db;

    private AppProperties(Db db) {
        this.db = db;
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

            return new AppProperties(db);

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

}

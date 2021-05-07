package com.prvz.urlchecker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Spark;

import java.util.List;

public class Application {

    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().findAndRegisterModules();
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Spark.initExceptionHandler((e) -> {
            logger.error("Initialization failed", e);
            System.exit(100);
        });
        Spark.port(8080);

        AppConfig appConfig = AppConfig.buildConfig();

        UrlsRepository repository = new UrlsRepository(appConfig.getDataSource());

        UrlsChecker urlsChecker = new UrlsChecker(repository, appConfig.getAppProperties());

        Spark.init();

        Spark.awaitInitialization();

        Router.init(repository);



    }



}

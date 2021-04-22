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

        Spark.path("/api/v1", () -> {

            Spark.before("/*", (req, res) ->
                logger.trace("Received api call ->\n {}", requestToString(req)));

            Spark.path("/urls", () -> {

                Spark.before("", (req, res) ->
                    logger.info("/urls call -> \n {}", requestToString(req)));

                Spark.post("", "application/json", (req, res) -> {
                    AddUrlRequest request = OBJECT_MAPPER.readValue(req.body(), AddUrlRequest.class);
                    repository.addUrl(request);
                    res.status(200);
                    return "";
                });

                Spark.get("", (req, res) -> {
                    String limitString = req.queryParams("limit");
                    int limit = 50;
                    if (limitString != null) {
                        try {
                            limit = Integer.parseInt(limitString);
                        } catch (NumberFormatException nfe) {
                            logger.warn("Incorrect limit value: " + limitString, nfe);
                        }
                    }
                    List<AddUrlResponse> result = repository.findAllOrderedByCreatedAt(limit);
                    res.type("application/json");
                    return OBJECT_MAPPER.writeValueAsString(result);
                });
            });
        });

    }

    public static String requestToString(Request request) {

        StringBuilder result = new StringBuilder()
            .append("Scheme: ").append(request.scheme()).append(", ")
            .append("Method: ").append(request.requestMethod()).append(", ")
            .append("Path: ").append(request.pathInfo());

        if (!"GET".equals(request.requestMethod())) {
            result.append("\n")
                .append("Body: ")
                .append(request.body());
        }

        result.append(".");
        return result.toString();
    }

}

package com.prvz.urlchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Spark;

import java.util.List;

public class Router {

    private static final Logger logger = LoggerFactory.getLogger(Router.class);

    static void init(UrlsRepository repository) {

        Spark.path("/api/v1", () -> {

            Spark.before("/*", (req, res) ->
                logger.trace("Received api call ->\n {}", requestToString(req)));

            Spark.path("/urls", () -> {

                Spark.before("", (req, res) ->
                    logger.info("/urls call -> \n {}", requestToString(req)));

                // save new url to repository
                Spark.post("", "application/json", (req, res) -> {
                    AddUrlRequest request = Application.OBJECT_MAPPER.readValue(req.body(), AddUrlRequest.class);
                    repository.addUrl(request);
                    res.status(200);
                    return "";
                });

                // get
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
                    return Application.OBJECT_MAPPER.writeValueAsString(result);
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

package com.codurance;

import com.codurance.infrastructure.http.Routes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.before;
import static spark.Spark.port;

public class Bank {
    private final Routes routes;

    private static Logger logger = LoggerFactory.getLogger(Bank.class);

    public Bank(Routes routes) {
        this.routes = routes;
    }

    public void start() {
        port(3000);
        setLog();
        routes.create();
    }

    private void setLog() {
        before((request, response) -> {
            logger.info("{} {}", request.requestMethod(), request.pathInfo());
        });
    }
}

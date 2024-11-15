package dev.hstr0100.dio.iss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@RestController
public class DefaultController {

    @GetMapping({"/", ""})
    public String getDefaultRoute() {
        return "Endpoints: /city/{cityName} /iss/{cityName}";
    }
}

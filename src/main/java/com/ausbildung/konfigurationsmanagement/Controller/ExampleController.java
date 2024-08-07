package com.ausbildung.konfigurationsmanagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ausbildung.konfigurationsmanagement.Constants.API_BASE_PATH;

/**
 * Dieser Controller ist zur Identifizierung des aktuell laufenden Servers dar.
 */

@RestController
@RequestMapping(API_BASE_PATH + "/example")
public class ExampleController {

    @Value("${server.name}")
    private String server;

    @GetMapping("/server")
    @Operation(summary = "Current server.")
    public String server() {
        return server;
    }

}

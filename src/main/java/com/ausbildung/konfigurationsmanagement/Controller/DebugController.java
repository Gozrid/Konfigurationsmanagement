package com.ausbildung.konfigurationsmanagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ausbildung.konfigurationsmanagement.Constants.API_BASE_PATH;

/**
 * Dieser Controller soll nur erreichbar sein, wenn die Anwendung auf dem Entwickler Rechner oder auf dem Test Server läuft!
 * Hier können einfache Debug Werkzeuge abgelegt werden.
 */

@RestController
@RequestMapping(API_BASE_PATH + "/test")
@ConditionalOnProperty(prefix = "server", name = "type", havingValue = "test")
public class DebugController {

    @GetMapping("/debug")
    @Operation(summary = "Debug controller for dev and test!")
    public String debug() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

}

package com.ausbildung.konfigurationsmanagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ausbildung.konfigurationsmanagement.Constants.API_BASE_PATH;

/**
 * Dieser Controller stellt die eigentlichen Funktionalitäten der Anwendung dar.
 * (Für normal würde man mehr Controller haben...)
 */

@RestController
@RequestMapping(API_BASE_PATH + "/prod")
public class ProdController {

    @Value("${server.says}")
    private String serverSays;

    @GetMapping("/saySomething")
    @Operation(summary = "Actual functionality of this application!")
    public String saySomething() {
        return serverSays;
    }

}

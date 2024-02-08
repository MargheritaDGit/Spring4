package com.example.Spring4;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class NameController {

    @GetMapping("/name")
    @Operation(summary = "restituisce nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })
    public String getName(@Parameter(description = "il nome che viene inserito") @RequestParam String name) {
        return name;
    }

    @PostMapping("/name")
    @Operation(summary = "restituisce nome al contrario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })
    public String getNameAlContrario(@RequestParam String name) {
        StringBuilder nameAlContrario = new StringBuilder(name);
        return nameAlContrario.reverse().toString();
    }
}

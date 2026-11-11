package com.onenest.backend.controller;

import com.onenest.backend.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ApiResponse home() {

        return new ApiResponse(
                "OneNest",
                "1.0",
                "Running",
                "Welcome to OneNest "
        );

    }

}
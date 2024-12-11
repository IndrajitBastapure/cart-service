package com.esn.api.cart_service.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        // Custom error handling logic
        return ResponseEntity.status(500).body("An unexpected error occurred.");
    }
}

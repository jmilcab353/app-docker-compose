package dev.jmilla.demo.controllers;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @GetMapping
    public String handleError(WebRequest webRequest, Model model) {
        // Get error details
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.defaults());

        // Add error details to the model for rendering
        model.addAttribute("timestamp", errorDetails.get("timestamp"));
        model.addAttribute("status", errorDetails.get("status"));
        model.addAttribute("error", errorDetails.get("error"));
        model.addAttribute("message", errorDetails.get("message"));
        model.addAttribute("path", errorDetails.get("path"));

        model.addAttribute("content", "error");

        // Return the Thymeleaf template for the error page
        return "layout";
    }
}

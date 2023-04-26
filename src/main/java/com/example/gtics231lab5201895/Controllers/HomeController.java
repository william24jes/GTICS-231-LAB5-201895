package com.example.gtics231lab5201895.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String menu() {

        return "recursosHumanos";
    }
}

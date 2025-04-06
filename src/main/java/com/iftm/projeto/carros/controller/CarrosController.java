package com.iftm.projeto.carros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarrosController {
    @GetMapping("/carros")
    public String getMethodName() {
        System.out.println("Teste");
        return "carros/index";
    }
}

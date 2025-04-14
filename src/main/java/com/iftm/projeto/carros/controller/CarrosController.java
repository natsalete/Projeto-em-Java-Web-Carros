package com.iftm.projeto.carros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.iftm.projeto.carros.model.Carros;
import com.iftm.projeto.carros.service.CarrosService;

@Controller
public class CarrosController {

    @Autowired
     private CarrosService carrosService;

    @GetMapping("/carros")
    public String index(Model model) {
        model.addAttribute("carrosList", carrosService.getAllCarros());
        return "carros/index";
    }
}

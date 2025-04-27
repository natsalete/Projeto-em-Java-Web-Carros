package com.iftm.projeto.carros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.iftm.projeto.carros.model.Carros;
import com.iftm.projeto.carros.service.CarrosService;
import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarrosController {

    @Autowired
     private CarrosService carrosService;

    @GetMapping("/carros")
    public String index(Model model) {
        model.addAttribute("carrosList", carrosService.getAllCarros());
        return "carros/index";
    }

    @GetMapping("/carros/create")
     public String create(Model model) {
         model.addAttribute("carros", new Carros());
         return "carros/create";
     }
 
     @PostMapping("/carros/save")
     public String postMethodName(@ModelAttribute("carros") Carros carros) {
         carrosService.saveCarros(carros);
         return "redirect:/carros";
     }
}

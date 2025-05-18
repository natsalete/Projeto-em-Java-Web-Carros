package com.iftm.projeto.carros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import com.iftm.projeto.carros.model.Carros;
import com.iftm.projeto.carros.service.CarrosService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

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
     public String postMethodName(@ModelAttribute @Valid Carros carros, BindingResult result) {
        if (result.hasErrors()) {
            return "carros/create";
        } 
    
        carrosService.saveCarros(carros);
         return "redirect:/carros";
     }

     @GetMapping("/carros/delete/{id}")
     public String delete(@PathVariable Long id) {
         this.carrosService.deleteCarrosById(id);
         return "redirect:/carros";
     }

     @GetMapping("/carros/edit/{id}")
     public String edit(@PathVariable Long id, Model model) {
         Carros carros = carrosService.getCarrosById(id);
         model.addAttribute("carros", carros);
         return "carros/edit";
     }
}

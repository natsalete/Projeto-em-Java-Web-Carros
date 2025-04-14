package com.iftm.projeto.carros.service;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.iftm.projeto.carros.model.Carros;
import com.iftm.projeto.carros.repository.CarrosRepository;
 
 @Service
 public class CarrosServiceImpl implements CarrosService {
 
     @Autowired
     private CarrosRepository carrosRepository;
 
     @Override
     public List <Carros> getAllCarros(){
         return carrosRepository.findAll();
     }
 
     @Override
     public void saveCarros(Carros carros){
         this.carrosRepository.save(carros);
     }
 
     @Override
     public Carros getCarrosById(long id) {
         Optional < Carros > optional = carrosRepository.findById(id);
         if (optional.isPresent()) {
             return optional.get();
         } else {
             throw new RuntimeException("Car not found with id: " + id);
         }
     }
 
     @Override
     public void deleteCarrosById(long id) {
         this.carrosRepository.deleteById(id);
     }
 
 }
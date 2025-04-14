package com.iftm.projeto.carros.service;

import java.util.List;

import com.iftm.projeto.carros.model.Carros;

public interface CarrosService {
    List <Carros> getAllCarros();
    void saveCarros(Carros product);
    Carros getCarrosById(long id);
    void deleteCarrosById(long id);
}    


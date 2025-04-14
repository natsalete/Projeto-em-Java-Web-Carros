package com.iftm.projeto.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;  
import com.iftm.projeto.carros.model.Carros;

@Repository 
public interface CarrosRepository extends JpaRepository<Carros, Long>{
    
}


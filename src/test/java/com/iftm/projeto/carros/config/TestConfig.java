package com.iftm.projeto.carros.config;

import com.iftm.projeto.carros.service.CarrosService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public CarrosService carrosService() {
        return Mockito.mock(CarrosService.class);
    }

}
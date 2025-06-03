package com.iftm.projeto.carros;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.iftm.projeto.carros.model.Carros;
import com.iftm.projeto.carros.repository.CarrosRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // Usa application-test.properties
@Transactional // Limpa o banco após cada teste
public class CarrosIntegrationTest {
    

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarrosRepository carrosRepository;

    @Test
    @WithMockUser(authorities = { "Admin" })
    void testSaveCarrosIntegration() throws Exception {

        Carros carrosA = new Carros();
        carrosA.setAno(2025);
        carrosA.setCombustivel("FLEX");
        carrosA.setCor("azul");
        carrosA.setMarca("Ferrari A");
        carrosA.setModelo("Puro Sangue");
        carrosA.setPlaca("ABC1234");
        carrosA.setQuilometragem(0f);
        carrosA.setRenavam("12345678912");


        mockMvc.perform(post("/carros/save")
                .with(csrf())
                .flashAttr("carros", carrosA))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/carros"));

        // Verifica no banco se foi salvo
        assertTrue(carrosRepository.findAll()
                .stream()
                .anyMatch(p -> "Ferrari A".equals(p.getMarca())));
        
    }
}
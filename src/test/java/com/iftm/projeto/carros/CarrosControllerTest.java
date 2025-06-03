package com.iftm.projeto.carros;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.iftm.projeto.carros.config.TestConfig;
import com.iftm.projeto.carros.controller.CarrosController;
import com.iftm.projeto.carros.model.Carros;
import com.iftm.projeto.carros.service.CarrosService;

@WebMvcTest(CarrosController.class)
@Import(TestConfig.class)
public class CarrosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarrosService carrosService;

    @AfterEach
    void resetMocks() {
        reset(carrosService);
    }

    private List<Carros> testCreateCarrosList(){
        Carros carrosB = new Carros();
        carrosB.setId(1L);
        carrosB.setAno(2025);
        carrosB.setCombustivel("FLEX");
        carrosB.setCor("azul");
        carrosB.setMarca("Ferrari B");
        carrosB.setModelo("Puro Sangue");
        carrosB.setPlaca("ABC1234");
        carrosB.setQuilometragem(0f);
        carrosB.setRenavam("12345678912");

        return List.of(carrosB);
    }

    @Test
    @DisplayName("GET /carros - Listar carros na tela index sem usuário autenticado")
    void testIndexNotAuthenticatedUser() throws Exception {
         mockMvc.perform(get("/carros"))
            .andExpect(status().isUnauthorized()); // Correção aqui
    }

    @Test
    @WithMockUser
    @DisplayName("GET /carros - Listar carros na tela index com usuário logado")
    void testIndexAuthenticatedUser() throws Exception {
        when(carrosService.getAllCarros()).thenReturn(testCreateCarrosList());

        mockMvc.perform(get("/carros"))
               .andExpect(status().isOk())
               .andExpect(view().name("carros/index"))
               .andExpect(model().attributeExists("carrosList"))
               .andExpect(content().string(containsString("Listagem de Carros")))
               .andExpect(content().string(containsString("Carro B")));
    }

    @Test
    @WithMockUser(username = "testeadmin@gmail.com", authorities = { "Admin" })
    @DisplayName("GET /carros/create - Exibe formulário de criação")
    void testCreateFormAuthorizedUser() throws Exception {
        mockMvc.perform(get("/carros/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("carros/create"))
                .andExpect(model().attributeExists("carros"))
                .andExpect(content().string(containsString("Cadastrar Carro")));
    }

    @Test
    @WithMockUser(username = "testemanager@gmail.com", authorities = { "Manager" })
    @DisplayName("GET /carros - Verificar o link de cadastrar para um usuario não admin logado")
    void testCreateFormNotAuthorizedUser() throws Exception {
        when(carrosService.getAllCarros()).thenReturn(testCreateCarrosList());
       // Obter o HTML da página renderizada pelo controlador
       mockMvc.perform(get("/carros/create"))
            .andExpect(status().isOk())
            .andExpect(view().name("carros/create"))
            .andExpect(model().attributeExists("carros"))
            .andExpect(content().string(not(containsString("<a class=\"dropdown-item\" href=\"/carros/create\">Cadastrar</a>"))));
    }

    @Test
    @WithMockUser
    @DisplayName("POST /carros/save - Falha na validação e retorna para o formulário")
    void testSaveCarrosValidationError() throws Exception {
        Carros carros = new Carros(); // Produto sem nome, o que causará erro de validação

        mockMvc.perform(post("/carros/save")
                        .with(csrf())
                        .flashAttr("carros", carros))
                .andExpect(status().isOk())
                .andExpect(view().name("carros/create"))
                .andExpect(model().attributeHasErrors("carros"));

        verify(carrosService, never()).saveCarros(any(Carros.class));
    }

    @Test
    @WithMockUser(username = "testeadmin@gmail.com", authorities = { "Admin" })
    @DisplayName("POST /carros/save - Carro válido é salvo com sucesso")
    void testSaveValidCarros() throws Exception {
        Carros carros = new Carros();
        carros.setAno(2025);
        carros.setCombustivel("FLEX");
        carros.setCor("azul");
        carros.setMarca("Ferrari");
        carros.setModelo("Puro Sangue");
        carros.setPlaca("ABC1234");
        carros.setQuilometragem(0f);
        carros.setRenavam("12345678912");

        mockMvc.perform(post("/carros/save")
                        .with(csrf())
                        .flashAttr("carros", carros))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/carros"));

        verify(carrosService).saveCarros(any(Carros.class));
    }

}
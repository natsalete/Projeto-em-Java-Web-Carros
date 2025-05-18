package com.iftm.projeto.carros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.Year;

@Entity
@Table(name = "carros")
public class Carros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 3, max = 50, message = "Placa deve conter pelo menos 3 caracteres")
    @NotBlank(message = "Placa é um campo obrigatório")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Placa deve conter apenas letras maiúsculas e números")
    @Column(name = "placa", nullable = false)
    private String placa;
 
    @NotBlank(message = "Marca é um campo obrigatório")
    @Size(min = 2, max = 50, message = "Marca deve conter entre 2 e 50 caracteres")
    @Column(name = "marca", nullable = false)
    private String marca;
 
    @NotBlank(message = "Modelo é um campo obrigatório")
    @Size(min = 2, max = 100, message = "Modelo deve conter entre 2 e 100 caracteres")
    @Column(name = "modelo", nullable = false)
    private String modelo;
     
    @NotNull(message = "Ano é um campo obrigatório")
    @Min(value = 1900, message = "Ano deve ser maior ou igual a 1900")
    @Column(name = "ano", nullable = false)
    private int ano;

    @NotBlank(message = "Cor é um campo obrigatório")
    @Size(min = 3, max = 30, message = "Cor deve conter entre 3 e 30 caracteres")
    @Column(name = "cor", nullable = false)
    private String cor;
 
    @NotBlank(message = "Renavam é um campo obrigatório")
    @Size(min = 9, max = 11, message = "Renavam deve conter entre 9 e 11 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "Renavam deve conter apenas números")
    @Column(name = "renavam", nullable = false)
    private String renavam;

    @NotBlank(message = "Combustível é um campo obrigatório")
    @Column(name = "combustivel", nullable = false)
    private String combustivel;

    @NotNull(message = "Quilometragem é um campo obrigatório")
    @PositiveOrZero(message = "Quilometragem não pode ser negativa")
    @Column(name = "quilometragem", nullable = false)
    private Float quilometragem;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getPlaca() {
        return placa;
    }
 
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
     
    public String getModelo() {
        return modelo;
    }
 
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }
 
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }
 
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }
 
    public String getCombustivel() {
        return combustivel;
    }
 
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    public void setCombustivelCorrigido(String combustivel) {
        this.combustivel = combustivel;
    }
 
    public Float getQuilometragem() {
        return quilometragem;
    }
 
    public void setQuilometragem(Float quilometragem) {
        this.quilometragem = quilometragem;
    }
}
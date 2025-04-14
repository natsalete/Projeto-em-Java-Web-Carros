package com.iftm.projeto.carros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carros")
public class Carros {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
 
     @Column(name = "placa", nullable = false)
     private String placa;
 
     @Column(name = "marca")
     private String marca;
 
     @Column(name = "modelo")
     private String modelo;
     
     @Column(name = "ano")
     private int ano;

     @Column(name = "cor")
     private String cor;
 
     @Column(name = "renavam")
     private String renavam;

     @Column(name = "combustivel")
     private String combustivel;

     @Column(name = "quilometragem")
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
 
     public void setCombsutivel(String combustivel) {
         this.combustivel = combustivel;
     }
 
     public Float getQuilometragem() {
         return quilometragem;
     }
 
     public void setQuilometragem(Float quilometragem) {
         this.quilometragem = quilometragem;
     }
}

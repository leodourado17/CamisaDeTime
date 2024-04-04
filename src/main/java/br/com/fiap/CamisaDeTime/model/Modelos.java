package br.com.fiap.tapago.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Modelos {

     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     @NotBlank
     private String nome;
     @NotBlank
     private Double preco;
     private String descricao;
}


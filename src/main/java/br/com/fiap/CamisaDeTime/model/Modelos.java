package br.com.fiap.virtualvibe.record;
 
import java.util.Random;
 
public record Modelos(Long id, String nome, Number preco, String descricao) {
     public Modelos(Long id, String nome, Number preco, String descricao){
        this.id  = Math.abs (new Random().nextLong());
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
}
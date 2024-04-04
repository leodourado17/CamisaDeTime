package br.com.fiap.CamisaDeTime.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.tapago.model.Categoria;
import br.com.fiap.tapago.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
 
 
@RestController
@RequestMapping("modelos")
@Slf4j
public class ModelosController {
   
     @Autowired // Injeção de Dependência - Inversão de Controle
    ModelosRepository repository;

    @GetMapping
    public List<Modelos> index() {
        return repository.findAll();
    }
    }
 
    @PostMapping
    @ResponseStatus(CREATED)
    public Modelos create(@RequestBody Modelos modelos) {
        log.info("Cadastrando modelos {}", modelos);
        return repository.save(modelos);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Modelos> show(@PathVariable Long id) {
        log.info("buscando modelos com id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


     @DeleteMapping("{id}")
     @ResponseStatus(NO_CONTENT)
     public void destroy(@PathVariable Long id) {
        log.info("apagando modelos {}", id);
        verificarSeModelosExiste(id);
        repository.deleteById(id);
    }
   
    @PutMapping("{id}")
    public Modelos update(@PathVariable Long id, @RequestBody Modelos modelos) {
        log.info("atualizar modelos {} para {}", id, modelos);

        verificarSeModelosExiste(id);
        modelos.setId(id);
        return repository.save(modelos);
    }

    private void verificarSeModelosExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe modelos com o id informado"));
    }


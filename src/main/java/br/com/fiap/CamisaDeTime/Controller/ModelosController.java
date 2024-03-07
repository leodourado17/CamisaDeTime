package br.com.fiap.virtualvibe.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import br.com.fiap.virtualvibe.record.Modelos;
 
 
@RestController
@RequestMapping("modelo")
public class ModelosController {
   
     Logger log = LoggerFactory.getLogger(getClass());
 
     List<Modelos> repository = new ArrayList<>();
 
     @GetMapping  
     public List<Modelos> index(){
        return repository;
    }
 
    @PostMapping
    public ResponseEntity<Modelos> create(@RequestBody Modelos gameModelos){ //binding
        log.info("Cadastrando Modelos {}", modelo);
        repository.add(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
    }
   
    @GetMapping("{id}")
    public ResponseEntity<Modelos> show(@PathVariable Long id){
        log.info("buscando modelo com id {}", id);
       
    //     for(Modelos modelo: repository){
    //         if (modelo.id().equals(id))
    //             return ResponseEntity.status(HttpStatus.OK).body(modelo);
    //     }

    
        var categoriaEncontrada = repository
                                    .stream()
                                    .filter(c -> c.id().equals(id))
                                    .findFirst();

        if(categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoriaEncontrada.get());

     }

     @DeleteMapping("{id}")
     public void destroy(@PathVariable Long id){
        log.info("apagando categoria {}", id);

         var categoriaEncontrada = repository
                                    .stream()
                                    .filter(c -> c.id().equals(id))
                                    .findFirst();

        if(categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(categoriaEncontrada.get());        
        
        return ResponseEntity.noContent().build();

    
    @PutMapping("{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("atualizar categoria {} para {}", id, categoria);

        // buscar a categoria antiga  - > 404
        var categoriaEncontrada = getCategoriaById(id);

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.not found().build();

        var categoriaAntiga = categoriaEncontrada.get();

        // criar a categoria nova com os dados atualizados

        var categoriaNova = new Categoria(id, categoria.nome(), categoria.icone());

        // apagar a categoria antiga

        repository.remove(categoriaAntiga);

        // add a categoria nova

        repository.add(categoriaNova);

        return ResponseEntity.ok().build();
    }

     }

}
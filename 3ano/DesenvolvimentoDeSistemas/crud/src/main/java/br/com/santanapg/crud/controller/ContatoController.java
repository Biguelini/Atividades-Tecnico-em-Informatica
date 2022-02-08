/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santanapg.crud.controller;

/**
 *
 * @author 2info2021
 */
import br.com.santanapg.crud.repository.ContatoRepository;
import br.com.santanapg.crud.vo.Contato;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping({"/contato"})
public class ContatoController {
    ContatoRepository repository;
    ContatoController(ContatoRepository contatoRepository){
        this.repository = contatoRepository;
    }
    @GetMapping
    public List findALl() {
        return repository.findAll();
    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contato> findById(@PathVariable int id){
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
        
    }
    @PostMapping
    public Contato create(@RequestBody Contato contato){
        return repository.save(contato);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Contato> update(@PathVariable("id") int id, @RequestBody Contato contato){
        return repository.findById(id).map(record -> {
            record.setNome(contato.getNome());
            record.setEmail(contato.getEmail());
            record.setTelefone(contato.getTelefone());
            Contato atualizado = repository.save(record);
            return ResponseEntity.ok().body(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id")int id) {
        return repository.findById(id).map(record -> { repository.deleteById(id);
            return ResponseEntity.ok().build();}).orElse(ResponseEntity.notFound().build());
    }
}

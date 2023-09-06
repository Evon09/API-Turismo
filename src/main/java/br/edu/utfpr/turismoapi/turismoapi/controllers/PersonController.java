package br.edu.utfpr.turismoapi.turismoapi.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.edu.utfpr.turismoapi.turismoapi.dto.PersonDTO;
import br.edu.utfpr.turismoapi.turismoapi.models.Person;
import br.edu.utfpr.turismoapi.turismoapi.repositories.PersonRepository;


@RestController
@RequestMapping("/pessoa")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = {"", "/"})
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<Person> personOpt =personRepository.findById(UUID.fromString(id));
        return personOpt.isPresent() ? ResponseEntity.ok(personOpt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody PersonDTO personDTO){
        Person pes = new Person();
        BeanUtils.copyProperties(personDTO, pes);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(pes));
        } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falhou ao criar pessoa");
        }
        
    }
    
    @PutMapping("/{id}")
    public String update(@RequestBody Long id){
        return "Updated: " + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return "Deleted: " + id;
    }
}

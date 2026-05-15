package com.facens.pet.controller;

import com.facens.pet.entity.Animal;
import com.facens.pet.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
@CrossOrigin("*")
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Animal salvar(@RequestBody Animal animal) {

        return repository.save(animal);

    }

    @GetMapping
    public List<Animal> listar() {

        return repository.findAll();

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        repository.deleteById(id);

    }

}
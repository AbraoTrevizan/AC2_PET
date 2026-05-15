package com.facens.pet.controller;

import com.facens.pet.dto.ConsultaDTO;
import com.facens.pet.entity.Consulta;
import com.facens.pet.repository.ConsultaRepository;
import com.facens.pet.service.ConsultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ConsultaController {

    private final ConsultaService consultaService;

    private final ConsultaRepository repository;

    public ConsultaController(
            ConsultaService consultaService,
            ConsultaRepository repository
    ) {

        this.consultaService = consultaService;
        this.repository = repository;

    }

    @PostMapping("/agendar")
    public Consulta agendar(
            @RequestBody ConsultaDTO dto
    ) {

        return consultaService.agendar(dto);

    }

    @GetMapping("/consultas")
    public List<Consulta> listar() {

        return repository.findAll();

    }

    @DeleteMapping("/consultas/{id}")
    public void excluir(
            @PathVariable Long id
    ) {

        repository.deleteById(id);

    }

}
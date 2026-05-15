package com.facens.pet.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idAnimal;

    private LocalDateTime dataHora;

    private String especialidadeRequisitada;

    @Column(length = 1000)
    private String historico;

    @ManyToOne
    private Veterinario veterinario;

    public Long getId() {
        return id;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getEspecialidadeRequisitada() {
        return especialidadeRequisitada;
    }

    public void setEspecialidadeRequisitada(String especialidadeRequisitada) {
        this.especialidadeRequisitada = especialidadeRequisitada;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
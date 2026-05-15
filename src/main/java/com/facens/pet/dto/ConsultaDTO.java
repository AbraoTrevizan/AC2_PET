package com.facens.pet.dto;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long idAnimal;

    private Long idVeterinario;

    private LocalDateTime dataHora;

    private String especialidadeRequisitada;

    private String historico;

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
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
}
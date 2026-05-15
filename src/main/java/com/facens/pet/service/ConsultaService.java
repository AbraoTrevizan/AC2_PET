package com.facens.pet.service;

import com.facens.pet.dto.ConsultaDTO;
import com.facens.pet.entity.Animal;
import com.facens.pet.entity.Consulta;
import com.facens.pet.entity.Veterinario;
import com.facens.pet.exception.RegraNegocioException;
import com.facens.pet.repository.AnimalRepository;
import com.facens.pet.repository.ConsultaRepository;
import com.facens.pet.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    private final AnimalRepository animalRepository;

    private final VeterinarioRepository veterinarioRepository;

    public ConsultaService(
            ConsultaRepository consultaRepository,
            AnimalRepository animalRepository,
            VeterinarioRepository veterinarioRepository
    ) {

        this.consultaRepository = consultaRepository;
        this.animalRepository = animalRepository;
        this.veterinarioRepository = veterinarioRepository;

    }

    public Consulta agendar(ConsultaDTO dto) {

        Animal animal =
                animalRepository.findById(dto.getIdAnimal())
                        .orElseThrow(() ->
                                new RegraNegocioException(
                                        "Animal não encontrado"
                                )
                        );

        Veterinario veterinario =
                veterinarioRepository.findById(
                        dto.getIdVeterinario()
                ).orElseThrow(() ->
                        new RegraNegocioException(
                                "Veterinário não encontrado"
                        )
                );

        boolean ocupado =
                consultaRepository
                        .existsByVeterinarioIdAndDataHora(
                                veterinario.getId(),
                                dto.getDataHora()
                        );

        if (ocupado) {

            throw new RegraNegocioException(
                    "Horário já ocupado"
            );

        }

        if (!veterinario.getEspecialidade()
                .equalsIgnoreCase(
                        dto.getEspecialidadeRequisitada()
                )) {

            throw new RegraNegocioException(
                    "Especialidade incompatível"
            );

        }

        Consulta consulta = new Consulta();

        consulta.setIdAnimal(animal.getId());
        consulta.setDataHora(dto.getDataHora());
        consulta.setHistorico(dto.getHistorico());
        consulta.setEspecialidadeRequisitada(
                dto.getEspecialidadeRequisitada()
        );
        consulta.setVeterinario(veterinario);

        return consultaRepository.save(consulta);

    }

}
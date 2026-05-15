package com.facens.pet;

import com.facens.pet.entity.Veterinario;
import com.facens.pet.repository.VeterinarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                PetApplication.class,
                args
        );

    }

    @Bean
    CommandLineRunner init(
            VeterinarioRepository repository
    ) {

        return args -> {

            if(repository.count() == 0){

                Veterinario vet = new Veterinario();

                vet.setNome("Dr. Carlos");
                vet.setEspecialidade("Clínica Geral");

                repository.save(vet);

            }

        };

    }

}
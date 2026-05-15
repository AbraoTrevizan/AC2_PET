package com.facens.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.facens.pet.entity.Veterinario;
import com.facens.pet.repository.VeterinarioRepository;

@SpringBootApplication
public class PetApplication implements CommandLineRunner {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetApplication.class, args);
    }

    @Override
    public void run(String... args) {

        if (veterinarioRepository.count() == 0) {

            Veterinario v1 = new Veterinario();
            v1.setNome("Carlos");
            v1.setEspecialidade("Clínica Geral");

            Veterinario v2 = new Veterinario();
            v2.setNome("Ana");
            v2.setEspecialidade("Dermatologia");

            Veterinario v3 = new Veterinario();
            v3.setNome("Pedro");
            v3.setEspecialidade("Ortopedia");

            Veterinario v4 = new Veterinario();
            v4.setNome("Julia");
            v4.setEspecialidade("Vacinação");

            veterinarioRepository.save(v1);
            veterinarioRepository.save(v2);
            veterinarioRepository.save(v3);
            veterinarioRepository.save(v4);
        }
    }
}

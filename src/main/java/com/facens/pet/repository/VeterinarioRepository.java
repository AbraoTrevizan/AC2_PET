package com.facens.pet.repository;

import com.facens.pet.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository
        extends JpaRepository<Veterinario, Long> {
}
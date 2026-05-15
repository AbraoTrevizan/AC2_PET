package com.facens.pet.repository;

import com.facens.pet.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository
        extends JpaRepository<Animal, Long> {
}
package com.animals.animals_api.Animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions for Animal entities.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {


    List<Animal> findByHabitatContainingIgnoreCase(String habitat);

    List<Animal> findByScientificNameContainingIgnoreCase(String scientificName);

    List<Animal> getAnimalsBySpecies(String species);

    // Custom query to find animals whose name contains a specific string (case-insensitive)
    @Query(value = "SELECT * FROM animals a WHERE LOWER(a.name) LIKE %?1%", nativeQuery = true)
    List<Animal> getAnimalsByNameContains(String keyword);
}

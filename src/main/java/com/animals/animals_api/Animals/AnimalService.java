package com.animals.animals_api.Animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Animal Database.
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique animal by its ID.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals of a given species.
     *
     * @param species the species to search for.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalsBySpecies(species);
    }
    /**
     * Get animals by habitat.
     *
     * @param habitat the habitat to search for.
     * @return a list of animals matching the habitat.
     */
    public List<Animal> getAnimalsByHabitat(String habitat) {
        return animalRepository.findByHabitatContainingIgnoreCase(habitat);
    }

    /**
     * Get animals by scientific name.
     *
     * @param scientificName the scientific name to search for.
     * @return a list of animals matching the scientific name.
     */
    public List<Animal> getAnimalsByScientificName(String scientificName) {
        return animalRepository.findByScientificNameContainingIgnoreCase(scientificName);
    }

    /**
     * Fetch all animals whose name contains a keyword.
     *
     * @param keyword the search keyword.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByNameContains(String keyword) {
        return animalRepository.getAnimalsByNameContains(keyword.toLowerCase());
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new Animal details.
     */
    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        if (existing != null) {
            existing.setName(animal.getName());
            existing.setScientificName(animal.getScientificName());
            existing.setSpecies(animal.getSpecies());
            existing.setHabitat(animal.getHabitat());
            existing.setDescription(animal.getDescription());

            animalRepository.save(existing);
        } else {
            // Handle the case where the animal does not exist
            throw new IllegalArgumentException("Animal with ID " + animalId + " does not exist.");
        }
    }

    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Animal Id.
     */
    public void deleteAnimalById(int animalId) {
        if (animalRepository.existsById(animalId)) {
            animalRepository.deleteById(animalId);
        } else {
            // Handle the case where the animal does not exist
            throw new IllegalArgumentException("Animal with ID " + animalId + " does not exist.");
        }
    }
}

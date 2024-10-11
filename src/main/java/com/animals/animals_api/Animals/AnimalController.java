package com.animals.animals_api.Animals;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    /**
     * Get a list of all Animals in the database.
     * Endpoint: GET http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * Endpoint: GET http://localhost:8080/animals/{animalId}
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getAnimalById(@PathVariable int animalId) {
        return animalService.getAnimalById(animalId);
    }

    /**
     * Add a new Animal entry.
     * Endpoint: POST http://localhost:8080/animals/new
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        animalService.addNewAnimal(animal);
        return animalService.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * Endpoint: PUT http://localhost:8080/animals/update/{animalId}
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new updated Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        animalService.updateAnimal(animalId, animal);
        return animalService.getAnimalById(animalId);
    }

    /**
     * Delete an Animal object.
     * Endpoint: DELETE http://localhost:8080/animals/delete/{animalId}
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        animalService.deleteAnimalById(animalId);
        return animalService.getAllAnimals();
    }

    /**
     * Get a list of Animals based on their species.
     * Endpoint: GET http://localhost:8080/animals?species=(animal species)
     *
     * @param species the species to search for.
     * @return A list of Animal objects matching the species.
     */
    @GetMapping("")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "defaultSpecies") String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    /**
     * Get a list of Animals based on their habitat.
     * Endpoint: GET http://localhost:8080/animals/habitat/{habitat}
     *
     * @param habitat the habitat to search for.
     * @return A list of Animal objects matching the habitat.
     */
    @GetMapping("/habitat/{habitat}")
    public List<Animal> getAnimalsByHabitat(@PathVariable String habitat) {
        return animalService.getAnimalsByHabitat(habitat);
    }

    /**
     * Get a list of Animals based on their scientific name.
     * Endpoint: GET http://localhost:8080/animals/scientificName/{scientificName}
     *
     * @param scientificName the scientific name to search for.
     * @return A list of Animal objects matching the scientific name.
     */
    @GetMapping("/scientificName/{scientificName}")
    public List<Animal> getAnimalsByScientificName(@PathVariable String scientificName) {
        return animalService.getAnimalsByScientificName(scientificName);
    }

    /**
     * Search for animals whose name contains a keyword.
     * Endpoint: GET http://localhost:8080/animals/search?keyword=(animal name)
     *
     * @param keyword the search keyword.
     * @return A list of Animal objects whose names contain the keyword.
     */
    @GetMapping("/search")
    public List<Animal> getAnimalsByNameContains(@RequestParam String keyword) {
        return animalService.getAnimalsByNameContains(keyword);
    }
}

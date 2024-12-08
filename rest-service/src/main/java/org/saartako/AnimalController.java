package org.saartako;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

    private final List<Animal> animals = List.of(
        new Animal("Dog", "Bobby", 10),
        new Animal("Cat", "Meow", 5),
        new Animal("Horse", "Tom", 80),
        new Animal("Zebra", "Martin", 60)
    );

    @GetMapping("/animal")
    public List<Animal> allAnimals() {
        return animals;
    }

    @GetMapping("/animal/{name}")
    public Animal allAnimalByName(@PathVariable(value = "name") String name) {
        final String lowercaseName = name.toLowerCase();
        return animals.stream().filter(animal -> animal.getName().toLowerCase().equals(lowercaseName)).findAny().orElse(null);
    }
}
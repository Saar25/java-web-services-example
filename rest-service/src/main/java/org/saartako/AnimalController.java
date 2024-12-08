package org.saartako;

import org.saartako.common.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

    private final List<Animal> animals = List.of(
        new Animal("Dog", "Bobby", 10),
        new Animal("Cat", "Meow", 5),
        new Animal("Cat", "Chubby", 6),
        new Animal("Cat", "Skinny", 4),
        new Animal("Horse", "Tom", 80),
        new Animal("Zebra", "Martin", 60)
    );

    @GetMapping("/animal")
    public List<Animal> allAnimals(@RequestParam(name = "type", required = false) String type) {
        return type == null ? animals : animals.stream().filter(
            animal -> animal.type().toLowerCase().equalsIgnoreCase(type)).toList();
    }

    @GetMapping("/animal/{name}")
    public Animal allAnimalByName(@PathVariable(name = "name") String name) {
        return animals.stream().filter(
            animal -> animal.name().toLowerCase().equalsIgnoreCase(name)).findAny().orElse(null);
    }
}
package org.saartako;

import org.saartako.common.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("animal")
public class AnimalController {

    private final List<Animal> animals = new ArrayList<>(Arrays.asList(
        new Animal("Dog", "Bobby", 10),
        new Animal("Cat", "Meow", 5),
        new Animal("Cat", "Chubby", 6),
        new Animal("Cat", "Skinny", 4),
        new Animal("Horse", "Tom", 80),
        new Animal("Lion", "Alex", 75),
        new Animal("Zebra", "Martin", 60)
    ));

    @GetMapping("")
    public List<Animal> allAnimals(@RequestParam(name = "type", required = false) String type) {
        return type == null ? animals : animals.stream().filter(
            animal -> animal.type().toLowerCase().equalsIgnoreCase(type)).toList();
    }

    @GetMapping("/{name}")
    public Animal allAnimalByName(@PathVariable(name = "name") String name) {
        return animals.stream().filter(
            animal -> animal.name().toLowerCase().equalsIgnoreCase(name)).findAny().orElse(null);
    }
}
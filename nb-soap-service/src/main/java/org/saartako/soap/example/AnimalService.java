/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package org.saartako.soap.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author saar
 */
@WebService(serviceName = "AnimalService")
public class AnimalService {

    private final List<Animal> animals = new ArrayList<>(Arrays.asList(
            new Animal("Dog", "Bobby", 10),
            new Animal("Cat", "Meow", 5),
            new Animal("Cat", "Chubby", 6),
            new Animal("Cat", "Skinny", 4),
            new Animal("Horse", "Tom", 80),
            new Animal("Lion", "Alex", 75),
            new Animal("Zebra", "Martin", 60)
    ));

    @WebMethod(operationName = "getAllAnimals")
    public List<Animal> getAllAnimals() {
        return animals;
    }

    @WebMethod(operationName = "getAnimalsOfType")
    public List<Animal> getAnimalsOfType(@WebParam(name = "type") String type) {
        return animals.stream()
                .filter(animal -> animal.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @WebMethod(operationName = "getAnimal")
    public Animal getAnimal(@WebParam(name = "name") String name) {
        final Animal animal = animals.stream().filter(
                a -> a.getName().equalsIgnoreCase(name)).findAny().orElse(null);

        return animal;
    }
}

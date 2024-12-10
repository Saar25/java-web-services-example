package org.saartako;

import org.saartako.gen.Animal;

public class App {
    public static void main(String[] args) {
        final AnimalServiceProxy animalServiceProxy = new AnimalServiceProxy();

        final Animal animal = animalServiceProxy.getAnimal("meow");
        System.out.println("Animal: " + animal.getName() + " (" + animal.getType() + ", " + animal.getWeight() + ")");
    }
}

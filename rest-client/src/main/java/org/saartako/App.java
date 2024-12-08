package org.saartako;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final AnimalServiceProxy animalServiceProxy = new AnimalServiceProxy();

        try {
            final String allAnimals = animalServiceProxy.getAllAnimals();

            System.out.println("All animals:\n" + allAnimals);

            final String animal1 = animalServiceProxy.getAnimalByName("tom");
            final String animal2 = animalServiceProxy.getAnimalByName("meow");

            System.out.println("Animal 1:\n" + animal1);
            System.out.println("Animal 2:\n" + animal2);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

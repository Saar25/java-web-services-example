package org.saartako;

import org.saartako.common.Animal;

import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final AnimalServiceProxy animalServiceProxy = new AnimalServiceProxy();

        try {
            final Animal[] allAnimals = animalServiceProxy.getAllAnimals();
            System.out.println("All animals:\n" + Arrays.toString(allAnimals));

            final Animal[] allCats = animalServiceProxy.getAllAnimalsOfType("cat");
            System.out.println("All cats:\n" + Arrays.toString(allCats));

            final Animal animal1 = animalServiceProxy.getAnimalByName("tom");
            System.out.println("Animal 1: " + animal1);

            final Animal animal2 = animalServiceProxy.getAnimalByName("meow");
            System.out.println("Animal 2: " + animal2);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

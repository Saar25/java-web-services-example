package org.saartako;

import org.saartako.gen.Animal;
import org.saartako.gen.GetAnimalRequest;
import org.saartako.gen.GetAnimalResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AnimalEndpoint {

    private static final String NAMESPACE_URI = "http://saartako.org/gen";

    private final List<Animal> animals = new ArrayList<>();

    public AnimalEndpoint() {
        Animal Bobby = new Animal();
        Bobby.setType("Dog");
        Bobby.setName("Bobby");
        Bobby.setWeight(10);
        animals.add(Bobby);
        Animal Meow = new Animal();
        Meow.setType("Cat");
        Meow.setName("Meow");
        Meow.setWeight(5);
        animals.add(Meow);
        Animal Chubby = new Animal();
        Chubby.setType("Cat");
        Chubby.setName("Chubby");
        Chubby.setWeight(6);
        animals.add(Chubby);
        Animal Skinny = new Animal();
        Skinny.setType("Cat");
        Skinny.setName("Skinny");
        Skinny.setWeight(4);
        animals.add(Skinny);
        Animal Tom = new Animal();
        Tom.setType("Horse");
        Tom.setName("Tom");
        Tom.setWeight(80);
        animals.add(Tom);
        Animal Alex = new Animal();
        Alex.setType("Lion");
        Alex.setName("Alex");
        Alex.setWeight(75);
        animals.add(Alex);
        Animal Martin = new Animal();
        Martin.setType("Zebra");
        Martin.setName("Martin");
        Martin.setWeight(60);
        animals.add(Martin);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnimalRequest")
    @ResponsePayload
    public GetAnimalResponse getAnimal(@RequestPayload GetAnimalRequest request) {
        GetAnimalResponse response = new GetAnimalResponse();

        final Animal animal = animals.stream().filter(
            a -> a.getName().equalsIgnoreCase(request.getName())).findAny().orElse(null);

        response.setAnimal(animal);

        return response;
    }
}
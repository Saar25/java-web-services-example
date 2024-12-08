package org.saartako;

import com.google.gson.Gson;
import org.saartako.common.Animal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AnimalServiceProxy {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public Animal[] getAllAnimals() throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal"))
            .GET()
            .build();

        final HttpResponse<String> response = httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return new Gson().fromJson(body, Animal[].class);
    }

    public Animal[] getAllAnimalsOfType(String type) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal?type=" + type))
            .GET()
            .build();

        final HttpResponse<String> response = httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return new Gson().fromJson(body, Animal[].class);
    }

    public Animal getAnimalByName(String name) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal/" + name))
            .GET()
            .build();

        final HttpResponse<String> response = httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return new Gson().fromJson(body, Animal.class);
    }
}

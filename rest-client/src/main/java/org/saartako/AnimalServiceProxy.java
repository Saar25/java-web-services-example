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

    private final Gson gson = new Gson();

    public Animal[] getAllAnimals() throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal"))
            .GET()
            .build();

        final HttpResponse<String> response = this.httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return this.gson.fromJson(body, Animal[].class);
    }

    public Animal[] getAllAnimalsOfType(String type) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal?type=" + type))
            .GET()
            .build();

        final HttpResponse<String> response = this.httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return this.gson.fromJson(body, Animal[].class);
    }

    public Animal getAnimalByName(String name) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal/" + name))
            .GET()
            .build();

        final HttpResponse<String> response = this.httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return this.gson.fromJson(body, Animal.class);
    }

    public boolean createAnimal(Animal animal) throws IOException, InterruptedException {
        final String json = this.gson.toJson(animal);

        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal"))
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .header("Content-Type", "application/json")
            .build();

        final HttpResponse<String> response = this.httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        return Boolean.parseBoolean(body);
    }
}

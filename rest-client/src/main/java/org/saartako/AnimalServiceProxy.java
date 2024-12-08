package org.saartako;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AnimalServiceProxy {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String getAllAnimals() throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal"))
            .GET()
            .build();

        final HttpResponse<String> response = httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getAnimalByName(String name) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/animal/" + name))
            .GET()
            .build();

        final HttpResponse<String> response = httpClient.send(
            request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

# Web services

This is an example of web services written in java using REST and SOAP principles

There are more ways of writing a web service, graphql for example  
You can see it in action at `https://graphql-demo.mead.io/`

## REST server

A RESTful server written using spring-boot and java

Run it through maven

```bash
mvn -pl rest-service clean spring-boot:run
```

Or via docker

```bash
docker compose run --rm --build rest-service
```

then access it through `http://localhost:8080/animal`  
or using rest-client module

## REST client

A dummy client that sends requests to the rest-server and prints them  
Run it using the ide or via maven

```bash
mvn -pl rest-client compile exec:java
```


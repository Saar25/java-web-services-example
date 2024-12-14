# Web services

This is an example of web services written in java using REST and SOAP principles

There are more ways of writing a web service, graphql for example  
You can see it in action at `https://graphql-demo.mead.io/`

## REST service

A RESTful service written using spring-boot and java

Run it through maven

```bash
mvn -pl rest-service clean spring-boot:run
```

Or via docker

```bash
docker compose up --build rest-service
```

then access it through `http://localhost:8080/animal`  
or using rest-client module

## REST client

A dummy client that sends requests to the rest-service and prints them  
Run it using the ide or via maven

```bash
mvn -pl rest-client compile exec:java
```

## SOAP service

A SOAP service written using spring-boot and java

Run it through maven

```bash
mvn -pl soap-service clean spring-boot:run
```

then access it through `http://localhost:8080/ws`  
or using soap-client module

## SOAP client

A dummy client that sends requests to the soap-service and prints them  
Run it using the ide or via maven

```bash
mvn -pl soap-client compile exec:java
```

or using curl

```bash
curl --header "content-type: text/xml" -d '
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:gs="http://saartako.org/gen">
  <soapenv:Header />
  <soapenv:Body>
    <gs:getAnimalRequest>
      <gs:name>Tom</gs:name>
    </gs:getAnimalRequest>
  </soapenv:Body>
</soapenv:Envelope>
' http://localhost:8080/ws 
```

which you can format using `... | xmllint --format -`

## nb soap

'nb-soap-service' and 'nb-soap-client' can be run using netbeans ide


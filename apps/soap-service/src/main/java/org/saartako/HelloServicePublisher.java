package org.saartako;

import javax.xml.ws.Endpoint;

public class HelloServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/hello", new HelloServiceImpl());

        System.out.println("Service is published at http://localhost:8080/hello?wsdl");
    }
}

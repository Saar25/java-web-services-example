package org.saartako;

import org.saartako.gen.Animal;
import org.saartako.gen.GetAnimalRequest;
import org.saartako.gen.GetAnimalResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class AnimalServiceProxy extends WebServiceGatewaySupport {

    public AnimalServiceProxy() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.saartako.gen");

        setDefaultUri("http://localhost:8080/ws");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    public Animal getAnimal(String name) {
        final GetAnimalRequest request = new GetAnimalRequest();
        request.setName(name);

        final GetAnimalResponse response = (GetAnimalResponse)
            getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getAnimal();
    }
}

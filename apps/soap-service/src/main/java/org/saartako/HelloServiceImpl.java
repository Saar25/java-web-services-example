package org.saartako;

import javax.jws.WebService;

@WebService(endpointInterface = "org.saartako.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}

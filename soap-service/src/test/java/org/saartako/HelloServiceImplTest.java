package org.saartako;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.saartako.gen.HelloService;
import org.saartako.gen.HelloServiceImplService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloServiceImplTest {

    private HelloService service;

    @BeforeEach
    public void setUp() {
        service = new HelloServiceImplService().getHelloServiceImplPort();
    }

    @Test
    public void testSayHello() {
        String result = service.sayHello("World");

        assertEquals("Hello, World!", result, "The greeting message should be correct.");
    }
}
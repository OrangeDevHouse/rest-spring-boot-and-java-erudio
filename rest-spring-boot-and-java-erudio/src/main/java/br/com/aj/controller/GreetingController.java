package br.com.aj.controller;

import br.com.aj.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s !!!";
    private final AtomicLong counter = new AtomicLong();

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){

        logger.info("Endpoint /greeting is called");

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting_pv/{name}")
    public Greeting greeting2(@PathVariable String name){

        logger.info("Endpoint /greeting_pv/{name} is called");

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

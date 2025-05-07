package vaoagost.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; // import org.springframework.web.bind.annotation.RequestMapping;

import vaoagost.model.Greeting;

@RestController  // @RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!"; // @Value("${greeting.template:Hello, %s!}")
    private final AtomicLong counter = new AtomicLong(); // @Value("${greeting.counter:0}")

    // http://localhost:8080/greeting?name=Vinicius
    @RequestMapping("/greeting") 
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

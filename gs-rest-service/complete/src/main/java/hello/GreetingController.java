package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

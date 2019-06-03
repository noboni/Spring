package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable String name) {
        Address address =new Address("2jldhfes","sdlfjlsw","asdfklesw","jlgf");
        List<String> teammembers = new ArrayList<>();
        teammembers.add( "Arafat");
        teammembers.add("Shahidul");
        teammembers.add("Shawrup");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name),address,teammembers);
    }
}

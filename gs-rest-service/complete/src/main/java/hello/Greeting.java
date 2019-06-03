package hello;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Greeting {

    private final long id;
    private final String content;
    private Address address;
    private List<String> teammembers;
}

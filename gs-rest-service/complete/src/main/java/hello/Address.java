package hello;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Address {
    private String house;
    private String street;
    private String thana;
    private String district;
}

package hello.model;

import hello.entity.Device;
import lombok.Data;

@Data
public class UserRequestModel {
    private String name;
    private Long age;
    private Device device;
}

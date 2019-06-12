package hello.model;

import lombok.Data;

@Data
public class DeviceResponseModel {
    private Long id;
    private String os;
    private String mac;
    private String deviceToken;
    private int version;
}

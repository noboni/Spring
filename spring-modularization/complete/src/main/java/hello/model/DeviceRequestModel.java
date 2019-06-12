package hello.model;
import lombok.Data;

@Data
public class DeviceRequestModel {
    private String os;
    private String mac;
    private String deviceToken;

}

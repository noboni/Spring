package hello.model;
import hello.entity.Device;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class DeviceRequestModel {
    private String os;
    private String mac;
    private String deviceToken;

}

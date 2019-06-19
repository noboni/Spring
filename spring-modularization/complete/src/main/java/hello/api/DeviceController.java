package hello.api;

import hello.entity.Device;
import hello.model.DeviceRequestModel;
import hello.model.DeviceResponseModel;
import hello.ResourceNotFoundException;
import hello.service.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class DeviceController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DeviceService deviceService;
    @GetMapping(path="/devices")
    public Iterable<DeviceResponseModel> getAllDevices() {
        return deviceService.getAll().stream().map(device -> modelMapper.map(device, DeviceResponseModel.class)).collect(Collectors.toList());

    }
    @PostMapping(path="/device")
    public DeviceResponseModel addDevice(@RequestBody DeviceRequestModel deviceRequestModel){
        Device device=modelMapper.map(deviceRequestModel,Device.class);
        return modelMapper.map(deviceService.save(device),DeviceResponseModel.class);
    }
    @GetMapping(path = "/device/{id}")
    public DeviceResponseModel getById(@PathVariable Long id) {
        return modelMapper.map(deviceService.get(id).get(),DeviceResponseModel.class);
    }
    @PutMapping(path="/device/{id}")
    public DeviceResponseModel updateDevice(@PathVariable Long id, @RequestBody DeviceRequestModel deviceRequestModel) throws ResourceNotFoundException {
        Device device=modelMapper.map(deviceRequestModel,Device.class);
        return modelMapper.map(deviceService.updateDevice(id,device),DeviceResponseModel.class);

    }
    @DeleteMapping(path="/device/{id}")
    public void deleteDevice(@PathVariable Long id) throws ResourceNotFoundException {
        deviceService.delete(id);
    }
}

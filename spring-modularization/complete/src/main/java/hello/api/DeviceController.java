package hello.api;

import hello.entity.Device;
import hello.model.DeviceRequestModel;
import hello.repository.DeviceRepository;
import hello.ResourceNotFoundException;
import hello.service.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class DeviceController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DeviceService deviceService;
    /*@GetMapping(path="/devices")
    public Iterable<Device> getAllDevices() {
        return deviceRepository.findAll();
    }*/
    @PostMapping(path="/device")
    public Device addDevice(@RequestBody DeviceRequestModel deviceRequestModel){
        Device device=modelMapper.map(deviceRequestModel,Device.class);
        System.out.println(device);
        return deviceService.save(device);
    }
   /* @GetMapping(path = "/device/{id}")
    public Device getById(@PathVariable Long id) throws ResourceNotFoundException {
        return deviceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Device not found for this id :: " + id));
    }
    @PutMapping(path="/device/{id}")
    public Device updateDevice(@PathVariable Long id, @RequestBody Device device) throws ResourceNotFoundException {
        Device existingDevice=deviceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Device not found for this id :: " + id));
        existingDevice.setMac(device.getMac());
        existingDevice.setDeviceToken(device.getDeviceToken());
        existingDevice.setOs(device.getOs());
        return deviceRepository.save(existingDevice);

    }
    @DeleteMapping(path="/device/{id}")
    public void deleteDevice(@PathVariable Long id) throws ResourceNotFoundException {
        Device device=deviceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Device not found for this id :: " + id));
        deviceRepository.delete(device);
    }*/
}

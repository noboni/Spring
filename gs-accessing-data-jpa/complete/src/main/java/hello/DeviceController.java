package hello;

import hello.Device;
import hello.DeviceRepository;
import hello.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;
    @GetMapping(path="/devices")
    public Iterable<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
    @PostMapping(path="/device")
    public Device addDevice(@RequestBody Device device){
        return deviceRepository.save(device);
    }
    @GetMapping(path = "/device/{id}")
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
    }
}

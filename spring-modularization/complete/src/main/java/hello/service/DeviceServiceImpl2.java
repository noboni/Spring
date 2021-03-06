package hello.service;

import hello.ResourceNotFoundException;
import hello.dao.DeviceDao;
import hello.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DeviceServiceImpl2 implements DeviceService{
    @Autowired
    DeviceDao deviceDao;
    public Optional<Device> get(Long id) {
        System.out.println(deviceDao.get(id));
        return deviceDao.get(id);
    }

    public List<Device> getAll() {
        return deviceDao.getAll();
    }
    public Device save(Device device) {
        return deviceDao.save(device);
    }
    public void delete(Long id) throws ResourceNotFoundException {
        Device device= deviceDao.get(id).orElseThrow(()->new ResourceNotFoundException("Device not found for this id :: " + id));
        deviceDao.delete(device);
    }
    public Device updateDevice(Long id,Device device) throws ResourceNotFoundException {
        Device existingDevice= deviceDao.get(id).orElseThrow(()->new ResourceNotFoundException("Device not found for this id :: " + id));
        existingDevice.setMac(device.getMac());
        existingDevice.setDeviceToken("Device: "+device.getDeviceToken());
        existingDevice.setOs(device.getOs()+" System");
        return deviceDao.save(existingDevice);

    }
}

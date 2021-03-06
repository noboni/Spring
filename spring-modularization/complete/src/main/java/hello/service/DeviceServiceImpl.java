package hello.service;

import hello.ResourceNotFoundException;
import hello.dao.DeviceDao;
import hello.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService{
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
        existingDevice.setDeviceToken(device.getDeviceToken());
        existingDevice.setOs(device.getOs());
        return deviceDao.save(existingDevice);

    }
}

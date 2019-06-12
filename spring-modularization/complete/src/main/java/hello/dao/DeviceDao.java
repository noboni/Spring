package hello.dao;

import hello.ResourceNotFoundException;
import hello.entity.Device;
import hello.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DeviceDao {
    @Autowired
    DeviceRepository deviceRepository;
    public Optional<Device> get(Long id) {
        return deviceRepository.findById(id);
    }

    public List<Device> getAll() {
        return deviceRepository.findAll();
    }
    public Device save(Device device) {
        return deviceRepository.save(device);
    }
    public void delete(Device device) {
        deviceRepository.delete(device);
    }
}
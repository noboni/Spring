package hello.service;

import hello.ResourceNotFoundException;
import hello.entity.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    Optional<Device> get(Long id);

    List<Device> getAll();
    Device save(Device device);
    void delete(Long id) throws ResourceNotFoundException;
    Device updateDevice(Long id,Device device) throws ResourceNotFoundException;
}

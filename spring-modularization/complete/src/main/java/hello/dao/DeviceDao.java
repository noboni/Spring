package hello.dao;

import hello.entity.Device;
import hello.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceDao {
    Optional<Device> get(Long id);

    List<Device> getAll();
    Device save(Device device);
    void delete(Device device);
}

package hello.service;

import hello.ResourceNotFoundException;
import hello.dao.DeviceDao;
import hello.dao.UserDao;
import hello.entity.Device;
import hello.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    DeviceService deviceService;
    public Optional<User> get(Long id) {
        System.out.println(userDao.get(id));
        return userDao.get(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
    public User save(User user) {
        user.setDevice(deviceService.save(user.getDevice()));
        return userDao.save(user);
    }
    public void delete(Long id) throws ResourceNotFoundException {
        User user=userDao.get(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
        userDao.delete(user);
    }
    public User updateUser(Long id,User user) throws ResourceNotFoundException {
        User existingUser=userDao.get(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
        existingUser.setAge(user.getAge());
        existingUser.setName(user.getName());
        existingUser.setDevice(deviceService.save(user.getDevice()));
        return userDao.save(existingUser);

    }
}

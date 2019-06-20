package hello.service;

import hello.ResourceNotFoundException;
import hello.dao.UserDao;
import hello.entity.Device;
import hello.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("2")
public class UserServiceImpl1 implements UserService{
    @Autowired
    UserDao userDao;
    @Value("${demo.service.imple.id}")
    String value;
    @Autowired
    ServiceLocator serviceLocator;
    //    DeviceService deviceService = serviceLocator.get(value);
    public Optional<User> get(Long id) {
        //System.out.println(userDao.get(id));
        return userDao.get(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
    public User save(User user) {
        user.setDevice(serviceLocator.get(value).save(user.getDevice()));
        return userDao.save(user);
    }
    public void delete(Long id) throws ResourceNotFoundException {
        User user= userDao.get(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
        userDao.delete(user);
    }
    public User updateUser(Long id,User user) throws ResourceNotFoundException {
        User existingUser= userDao.get(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
        existingUser.setAge(user.getAge());
        existingUser.setName("name:"+user.getName());
        DeviceService deviceService = serviceLocator.get(value);
        Device device = deviceService.save(user.getDevice());
        existingUser.setDevice(device);
        return userDao.save(existingUser);

    }
}


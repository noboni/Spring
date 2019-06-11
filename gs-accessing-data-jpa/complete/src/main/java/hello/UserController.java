package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path="/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping(path="/user")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping(path = "/user/{id}")
    public User getById(@PathVariable Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
    }
    @PutMapping(path="/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws ResourceNotFoundException {
        User existingUser=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
        existingUser.setAge(user.getAge());
        existingUser.setName(user.getName());
        existingUser.setDevice(user.getDevice());
        return userRepository.save(existingUser);

    }
    @DeleteMapping(path="/user/{id}")
    public void deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + id));
        userRepository.delete(user);
    }
}

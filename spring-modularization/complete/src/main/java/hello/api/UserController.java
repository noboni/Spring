package hello.api;

import hello.entity.User;
import hello.model.UserRequestModel;
import hello.model.UserResponseModel;
import hello.ResourceNotFoundException;
import hello.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class UserController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserService userService;
    @GetMapping(path="/users")
    public Iterable<UserResponseModel> getAllUsers() {
        return userService.getAll().stream().map(user -> modelMapper.map(user, UserResponseModel.class)).collect(Collectors.toList());

    }
    @PostMapping(path="/user")
    public UserResponseModel addUser(@RequestBody UserRequestModel userRequestModel){
        User user=modelMapper.map(userRequestModel,User.class);
        return modelMapper.map(userService.save(user),UserResponseModel.class);
    }
    @GetMapping(path = "/user/{id}")
    public UserResponseModel getById(@PathVariable Long id) {
        return modelMapper.map(userService.get(id).get(),UserResponseModel.class);
    }
    @PutMapping(path="/user/{id}")
    public UserResponseModel updateUser(@PathVariable Long id, @RequestBody UserRequestModel userRequestModel) throws ResourceNotFoundException {
        User user=modelMapper.map(userRequestModel,User.class);
        return modelMapper.map(userService.updateUser(id,user),UserResponseModel.class);

    }
    @DeleteMapping(path="/user/{id}")
    public void deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
        userService.delete(id);
    }
}

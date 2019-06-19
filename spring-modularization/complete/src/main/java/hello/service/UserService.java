package hello.service;

import hello.ResourceNotFoundException;
import hello.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> get(Long id);

    List<User> getAll();
    User save(User device);
    void delete(Long id) throws ResourceNotFoundException;
    User updateUser(Long id,User device) throws ResourceNotFoundException;
}

package hello.dao;

import hello.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> get(Long id);
    List<User> getAll();
    User save(User user);
    void delete(User user);
}

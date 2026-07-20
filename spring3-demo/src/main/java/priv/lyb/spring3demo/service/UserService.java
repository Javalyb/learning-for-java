package priv.lyb.spring3demo.service;

import priv.lyb.spring3demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User userDetails);

    void deleteUser(Long id);
}

package spring_mvc.service;

import spring_mvc.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
    boolean addUser(User user);
    void deleteUser(Long id);
    void editUser(User user);
}

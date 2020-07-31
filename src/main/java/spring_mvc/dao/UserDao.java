package spring_mvc.dao;

import spring_mvc.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    List<User> listUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
}
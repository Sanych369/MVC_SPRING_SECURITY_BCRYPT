package spring_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_mvc.dao.UserDao;
import spring_mvc.model.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {

        User userFromDB = userDao.getUserByUsername(user.getUsername());

        if (userFromDB != null) {   //Проверка, есть ли уже пользователь с таким именем
            return false;
        }

        user.setRoles(Collections.singleton(roleService.getRole(1L))); //Назначаем по умолчанию новому юзеру роль USER
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        bCryptPasswordEncoder.encode
        userDao.addUser(user);
        return true;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userDao.getUserById(id);
        user.setRoles(null);
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        bCryptPasswordEncoder.encode
        userDao.editUser(user);
    }
}
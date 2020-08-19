package spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring_mvc.model.User;
import spring_mvc.service.UserService;
import spring_mvc.util.UtilService;

import java.util.List;

@Controller
//@RequestMapping("/")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String listUsers(ModelMap modelMap, Authentication authentication) {
        List<User> userList = userService.listUsers();
        modelMap.put("users", userList);
        System.out.println(authentication.getPrincipal());
        System.out.println(userList);
        return "index";
    }

    @GetMapping("/admin/addUser")
    public String getAddUser() {
        return "addUser";
    }

    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:";
    }

    @GetMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:";
    }

    @GetMapping("/admin/editUser")
    public String editUserGet(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.put("user", user);
        return "editUser";
    }

    @PostMapping("/admin/editUser")
    public String editUserPost(@ModelAttribute User user, @RequestParam(value = "role") String[] rolesArr) {
        user.setRoles(UtilService.stringArrToSetRoles(rolesArr));
        userService.editUser(user);
        return "redirect:";
    }
}
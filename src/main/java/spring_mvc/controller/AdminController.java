package spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring_mvc.model.User;
import spring_mvc.service.UserService;
import spring_mvc.util.UtilService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", ""})
    public String listUsers(ModelMap modelMap) {
        List<User> users = userService.listUsers();
        modelMap.put("users", users);
        return "index";
    }

    @GetMapping("/addUser")
    public String getAddUser() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:";
    }

    @GetMapping("/editUser")
    public String editUserGet(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.put("user", user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUserPost(@ModelAttribute User user, @RequestParam(value = "role") String[] rolesArr) {
        user.setRoles(UtilService.stringArrToSetRoles(rolesArr));
        userService.editUser(user);
        return "redirect:";
    }
}
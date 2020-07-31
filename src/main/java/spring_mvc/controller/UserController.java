package spring_mvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_mvc.model.User;

@Controller
@RequestMapping("")
public class UserController {

    @GetMapping("/hello")
    public String getUserPage(ModelMap modelMap) {
        User user = (User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        modelMap.put("user", user);
        return "hello";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}

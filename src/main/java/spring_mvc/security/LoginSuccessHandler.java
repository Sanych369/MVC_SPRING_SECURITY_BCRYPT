package spring_mvc.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import spring_mvc.model.Role;
import spring_mvc.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    // Spring Security использует объект Authentication, пользователя авторизованной сессии.

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {

//        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        User user = (User) authentication.getPrincipal();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(user);
        List<String> rolelist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            rolelist.add(role.getName());
        }
        System.out.println(rolelist);
        if (rolelist.contains("ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
        } else if (rolelist.contains("USER")){
            httpServletResponse.sendRedirect("/hello");
        } else {
            System.out.println("Для такого пользователя нет кабинета");
        }
    }
}
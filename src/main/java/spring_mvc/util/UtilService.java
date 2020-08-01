package spring_mvc.util;

import spring_mvc.model.Role;

import java.util.HashSet;
import java.util.Set;

public class UtilService {

    public static Set<Role> stringArrToSetRoles(String[] rolesArr) {

        Set<Role> roles = new HashSet<>();
        for (String role : rolesArr) {
            if (role.equals("ADMIN")) {
                Role roleAdmin = new Role(2L, "ADMIN");
                roles.add(roleAdmin);
            }
            if (role.equals("USER")) {
                Role roleUser = new Role(1L, "USER");
                roles.add(roleUser);
            }
        }
        return roles;
    }
}

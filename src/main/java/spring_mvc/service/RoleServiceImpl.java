package spring_mvc.service;

import org.springframework.stereotype.Service;
import spring_mvc.dao.RoleDao;
import spring_mvc.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }
}

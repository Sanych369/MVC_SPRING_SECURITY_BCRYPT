package spring_mvc.dao;

import org.springframework.stereotype.Repository;
import spring_mvc.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRole(Long id) {
        return entityManager.getReference(Role.class, id);
    }
}

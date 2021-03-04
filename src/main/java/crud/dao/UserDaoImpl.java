package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }
}

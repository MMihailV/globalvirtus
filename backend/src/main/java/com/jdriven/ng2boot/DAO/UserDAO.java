package com.jdriven.ng2boot.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdriven.ng2boot.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        String hql = "FROM User as usr ORDER BY usr.id DESC";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(User user) {
        User usr = getUserById(Math.toIntExact(user.getId()));
        usr.setFirstName(user.getFirstName());
        usr.setLastName(user.getLastName());
        usr.setLogin(user.getLogin());
        usr.setPassword(user.getPassword());
        usr.setEmail(user.getEmail());
        usr.setFK_Role(user.getFK_Role());
        entityManager.flush();
    }
    @Override
    public void deleteUser(int userId) {
        entityManager.remove(getUserById(userId));
    }
    @Override
    public boolean userExists(Long id, String firstName, String lastName, String email, String login, String password, Long FK_Role) {
        String hql = "FROM User as usr WHERE usr.firstName = firstName and usr.lastName = lastName";
        int count = entityManager.createQuery(hql).setParameter('0', id).setParameter('1', firstName)
                .setParameter('2', lastName).setParameter('3', email).setParameter('4', login).setParameter('5', password).setParameter('6', FK_Role).getResultList().size();
        return count > 0 ? true : false;
    }
    @Override
    public boolean userExists(String login, String password) {
        String hql = "FROM User as usr WHERE usr.login = ? and usr.password = ?";
        int count = entityManager.createQuery(hql).setParameter(Integer.parseInt("1"), login)
                .setParameter(Integer.parseInt("2"), password).getResultList().size();
        return count > 0 ? true : false;
    }
}
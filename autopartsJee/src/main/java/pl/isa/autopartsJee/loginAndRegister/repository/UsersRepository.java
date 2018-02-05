package pl.isa.autopartsJee.loginAndRegister.repository;

import pl.isa.autopartsJee.loginAndRegister.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UsersRepository {
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
    public void addUser(User user){
        entityManager.persist(user);
    }


    public User findUserByLogin(String login){
        return (User) entityManager.createQuery("from User u where u.login=:login")
                .setParameter("login", login)
                .getSingleResult();
    }
    public List<User> getAllUsers(){
        return entityManager.createQuery("from User").getResultList();
    }
}

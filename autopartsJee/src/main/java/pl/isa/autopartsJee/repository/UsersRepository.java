package pl.isa.autopartsJee.repository;

import pl.isa.autopartsJee.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsersRepository {
    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
    public void addUser(User user){
        entityManager.persist(user);
    }
    public User findUserByLogin(String login){
        return (User) entityManager.createQuery("from users u where u.login=:login")
                .setParameter("login", login)
                .getSingleResult();
    }
}

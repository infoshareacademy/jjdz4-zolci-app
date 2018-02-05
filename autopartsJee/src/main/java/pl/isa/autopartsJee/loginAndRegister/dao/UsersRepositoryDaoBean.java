package pl.isa.autopartsJee.loginAndRegister.dao;

import pl.isa.autopartsJee.loginAndRegister.domain.User;
import pl.isa.autopartsJee.loginAndRegister.repository.UsersRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao{
@EJB
UsersRepository usersRepository;
    @Override
    public void addUser(User user) {
    usersRepository.addUser(user);

    }

    @Override
    public User findUserByLogin(String login) {
        return usersRepository.findUserByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.getAllUsers();
    }
}

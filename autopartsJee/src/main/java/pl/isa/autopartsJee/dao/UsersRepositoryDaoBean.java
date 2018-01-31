package pl.isa.autopartsJee.dao;

import pl.isa.autopartsJee.domain.User;
import pl.isa.autopartsJee.repository.UsersRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao{
@EJB
    UsersRepository usersRepository;
    @Override
    public void addUser(User user) {
    usersRepository.addUser(user);

    }
}

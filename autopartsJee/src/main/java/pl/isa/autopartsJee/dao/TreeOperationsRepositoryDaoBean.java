package pl.isa.autopartsJee.dao;

import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autopartsJee.repository.TreeOperationsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TreeOperationsRepositoryDaoBean implements TreeOperationsRepositoryDao{
    @EJB
    TreeOperationsRepository treeOperationsRepository;
    @Override
    public TreeOperations getRepository() {
        return treeOperationsRepository.getRepository();
    }

    @Override
    public void initRepository() {
        treeOperationsRepository.initRepository();
    }
}

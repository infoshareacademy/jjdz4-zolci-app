package pl.isa.autopartsJee.dao;

import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autopartsJee.repository.TreeOperationsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TreeOperationsDaoBean implements TreeOperationsDao{
    @EJB
    private TreeOperationsRepository treeOperationsRepository;
    @Override
    public TreeOperations getTreeOperations() {
        return treeOperationsRepository.getRepository();
    }
}

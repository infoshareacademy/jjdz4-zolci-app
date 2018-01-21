package pl.isa.autopartsJee.dao;

import pl.isa.autoparts.categories.TreeOperations;
import pl.isa.autopartsJee.repository.TreeOperationsRepository;

import javax.ejb.Stateless;

@Stateless
public class TreeOperationsDaoBean implements TreeOperationsDao{

    @Override
    public TreeOperations getTreeOperations() {
        return TreeOperationsRepository.getRepository();
    }
}

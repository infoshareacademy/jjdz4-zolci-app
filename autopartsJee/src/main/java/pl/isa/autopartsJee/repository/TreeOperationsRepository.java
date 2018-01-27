package pl.isa.autopartsJee.repository;

import pl.isa.autoparts.categories.TreeOperations;

import javax.ejb.Stateless;

@Stateless
public class TreeOperationsRepository {
    TreeOperations treeOperations = new TreeOperations();

    public TreeOperations getRepository() {
        return treeOperations;
    }
}

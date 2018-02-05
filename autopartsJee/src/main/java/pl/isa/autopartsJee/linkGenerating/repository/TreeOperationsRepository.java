package pl.isa.autopartsJee.linkGenerating.repository;

import pl.isa.autoparts.categories.TreeOperations;

import javax.ejb.Stateless;

@Stateless
public class TreeOperationsRepository {
    TreeOperations treeOperations;

    public TreeOperations getRepository() {
        return treeOperations;
    }
    public void initRepository() {treeOperations = new TreeOperations();}
}

package pl.isa.autopartsJee.dao;

import pl.isa.autoparts.categories.TreeOperations;

import javax.ejb.Local;

@Local
public interface TreeOperationsRepositoryDao {
    TreeOperations getRepository();
}

package pl.isa.autopartsJee.dao;

import pl.isa.autoparts.categories.TreeOperations;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TreeOperationsDao {


    TreeOperations getTreeOperations();
}
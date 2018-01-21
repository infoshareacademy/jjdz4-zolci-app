package pl.isa.autopartsJee.repository;

import pl.isa.autoparts.categories.TreeOperations;

import java.util.ArrayList;
import java.util.List;

public class TreeOperationsRepository {
    private static TreeOperations treeOperations = new TreeOperations();
    public static TreeOperations getRepository() {
        return treeOperations;
    }
}

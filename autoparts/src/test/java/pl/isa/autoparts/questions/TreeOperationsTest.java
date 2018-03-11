package pl.isa.autoparts.questions;

import org.junit.Before;
import org.junit.Test;
import pl.isa.autoparts.categories.AllegroItem;
import pl.isa.autoparts.categories.TreeOperations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TreeOperationsTest {
    TreeOperations treeOperations;

    @Before
    public void init() {
        treeOperations = new TreeOperations();
    }

    @Test
    public void should_return_category() {

        assertThat(treeOperations.findExactCarPartCategory("drzwi boczne").getId(), is(18702));
    }
    @Test
    public void should_find_car_parts_category_list(){
        treeOperations.findCarPartCategoryList("drzwi");
        assertThat(treeOperations.getSimilarList().size(), is(6));
    }
}

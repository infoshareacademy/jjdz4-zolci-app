package pl.isa.autoparts.categories;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AllegroItem {
//    private static final Logger logger = Logger.getLogger(AllegroItem.class.getName());
    private int id;
    private String name;
    private int parentId;

    private ArrayList<AllegroItem> children = new ArrayList<AllegroItem>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parentId;
    }

    public void setParent(int parent) {
        this.parentId = parent;
    }


    public void setChildren(ArrayList<AllegroItem> allegroList) {
        for (int i = 0; i < allegroList.size(); i++) {
            AllegroItem child = allegroList.get(i);

            if (this.id == child.getParent()) {
                this.children.add(child);

                child.setChildren(allegroList);
            }
        }
    }


    public ArrayList<AllegroItem> getChildren() {
        return children;
    }


}

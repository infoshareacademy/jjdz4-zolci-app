package pl.isa.autoparts.categories;

import java.util.ArrayList;

public class AllegroItem {
    private int id;
    private String name;
    private int parentId;

    private ArrayList<AllegroItem> children = new ArrayList<AllegroItem>();

    public AllegroItem getParent() {
        return parent;
    }

    public void setParent(AllegroItem parent) {
        this.parent = parent;
    }

    private AllegroItem parent;

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parent) {
        this.parentId = parent;
    }


    public void createChildrenList(ArrayList<AllegroItem> allegroList) {
        for (int i = 0; i < allegroList.size(); i++) {
            AllegroItem child = allegroList.get(i);

            if (this.id == child.getParentId()) {
                this.children.add(child);

                child.createChildrenList(allegroList);
            }
        }
    }


    public ArrayList<AllegroItem> getChildren() {
        return children;
    }


}
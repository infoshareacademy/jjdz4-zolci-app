package pl.isa.parserXML;

import java.util.ArrayList;

public class AllegroItem {

    private int id;
    private String name;
    private int parent;
    private int position;

    private ArrayList<AllegroItem> children = new ArrayList<AllegroItem>();

    private AllegroItem parentObject;

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
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setChildren(ArrayList<AllegroItem> allegroList) {
        for (int i = 0; i < allegroList.size(); i++) {
            AllegroItem child = allegroList.get(i);

            if (this.id == child.getParent()) {
                child.setParentObject(this);
                this.children.add(child);

                child.setChildren(allegroList);
            }
        }
    }

    public void setParentObject(AllegroItem item) {
        this.parentObject = item;
        this.parent = item.getParent();
    }


    public ArrayList<AllegroItem> getChildren() {
        return children;
    }


    public AllegroItem getParentObject() {
        return parentObject;
    }
}

package pl.isa.parserXML;

import java.util.ArrayList;

public class AllegroItem {

    private int id;
    private String name;
    private int parent;
    private int position;
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
            if (this.id == allegroList.get(i).getParent()) {
                this.children.add(allegroList.get(i));
                allegroList.get(i).setChildren(allegroList);
            }
        }
    }

    public void printTree(int stars) {
        stars++;
        for (AllegroItem item : this.children) {
            for(int i=0; i<stars; i++) {
                System.out.print("*");
            }

            System.out.println(item.getName());
            item.printTree(stars);

        }
    }
}

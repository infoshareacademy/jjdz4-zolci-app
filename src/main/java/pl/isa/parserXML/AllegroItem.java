package pl.isa.parserXML;

import java.util.Map;

public class AllegroItem {

    private int id;
    private String name;
    private int parent;
    private int position;


//    public static void mainCategories(Map<Integer, AllegroItem> map) {
//        Integer result_tmp = 0;
//        Integer result_tmp2;
//        String valu_tmp = "tmp";
//
//        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
//            if (result_tmp.equals(entry.getValue().getParent())) {
//                result_tmp2 = entry.getKey();
//                valu_tmp = entry.getValue().getName();
//                System.out.print("Id: " + result_tmp2);
//                System.out.println(" - Category name: " + valu_tmp);
//            }
//        }
//    }


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
}

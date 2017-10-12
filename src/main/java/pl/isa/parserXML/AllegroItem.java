package pl.isa.parserXML;

import java.util.*;

public class AllegroItem {

    private int id;
    private String name;
    private int parentId;
    private int position;
    Scanner scanner = new Scanner(System.in);

    //    choosing options from keyboard
    public int readData(List<Integer> tmpList) {
        int result_tmp;

        System.out.print("\nWybierz numer kategorii: ");
        result_tmp = tmpList.get(scanner.nextInt() - 1);

        return result_tmp;
    }




    //    filtering categories
    public List<Integer> allegroCategories(Map<Integer, AllegroItem> map, Integer result_tmp) {

        List<Integer> tmpList = new ArrayList<>();
        Map<Integer, String> tmpMap = new HashMap<>();

        int i = 1;

        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result_tmp.equals(entry.getValue().getParentId())) {

                System.out.print("Id: " + entry.getKey());
                System.out.println(" : " + (i++) + " - Category name: " + entry.getValue().getName());
                tmpList.add(entry.getKey());

                tmpMap.put(entry.getKey(), entry.getValue().getName());
//                continue;
            }
        }
        return tmpList;
    }


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

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

package pl.isa.parserXML;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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


//    public Integer readData(Map<Integer, AllegroItem> map) {
//        Integer result_tmp;
//
//        System.out.print("\nWybierz numer kategorii: ");
//        result_tmp = map.get(scanner.nextInt() - 1).getId();
////        result_tmp = tmpList.get(scanner.nextInt() - 1);
////        int licznik = 100;
////        result_tmp = scanner.nextInt();
////        for(Map.Entry entry : map.entrySet()){
////            if (licznik == result_tmp) {
////                result_tmp = (Integer) entry.getKey();
//////                return result_tmp;
////                break;
////            }
////        }
//
//        return result_tmp;
//    }



    //    filtering categories
    public List<Integer> allegroCategories(Map<Integer, AllegroItem> map, Integer result_tmp) {

        List<Integer> tmpList = new ArrayList<>();
//        Map<Integer, String> tmpMap = new HashMap<>();

        int i = 1;

        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result_tmp.equals(entry.getValue().getParentId())) {

                System.out.print("Id: " + entry.getKey());
                System.out.println(" : " + (i++) + " - Category name: " + entry.getValue().getName());
                tmpList.add(entry.getKey());
            }
        }
        return tmpList;
    }


//    AllegroItem item1 = new AllegroItem();
//    List<Integer> tmpList = new ArrayList<>();
//    Integer result_tmp = 0;
//
//    //Map -> Stream -> Filter -> MAP
//    Map<Integer, AllegroItem> collect = mapM.entrySet().stream()
//            .filter(map -> map.getValue().getParentId() == 2)
//            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
//        System.out.println("With Java 8 : " + collect.keySet());



//    public Map<Integer, AllegroItem> mojaFunkcja(Map<Integer, AllegroItem> mapM, int result_tmp) {
//        List<Integer> tmpList = new ArrayList<>();
//
////        Map -> Stream -> Filter -> MAP
//        Map<Integer, AllegroItem> collect = mapM.entrySet().stream()
//                .filter(map -> map.getValue().getParentId() == result_tmp)
//                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
////        System.out.println("With Java 8 : " + collect.keySet());
//
//
//        return collect;
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

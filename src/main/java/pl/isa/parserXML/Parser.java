package pl.isa.parserXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static void main(String[] args) {
        AllegroItem allegroItem;
        List<AllegroItem> allegroList = new ArrayList<AllegroItem>();
        List<AllegroItem> sameParent = new ArrayList<AllegroItem>();

        Map<Integer, AllegroItem> map = new HashMap<>();

        try {
            File inputFile = new File("src/Allegro_cathegories_2016-02-13.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("ns1:item");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
//                System.out.println("\nIteam");
                allegroItem = new AllegroItem();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    allegroItem.setId(Integer.parseInt(eElement
                            .getElementsByTagName("ns1:catId")
                            .item(0)
                            .getTextContent()));

                    allegroItem.setName(eElement
                            .getElementsByTagName("ns1:catName")
                            .item(0)
                            .getTextContent());

                    allegroItem.setParent(Integer.parseInt(eElement
                            .getElementsByTagName("ns1:catParent")
                            .item(0)
                            .getTextContent()));

                    allegroItem.setPosition(Integer.parseInt(eElement
                            .getElementsByTagName("ns1:catPosition")
                            .item(0)
                            .getTextContent()));

                 //   allegroList.add(allegroItem);

                    map.put(allegroItem.getId(), allegroItem);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(map.get(253498).getName());

        String value = "Akcesoria samochodowe";
        Integer result = 0;
        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (value.equals(entry.getValue().getName())) {
//                result = entry.getValue();
                result = entry.getKey();
                System.out.println("Parentid: " + result);
            }
        }
        Integer result2 = 0;
        String value2 = "";
        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result.equals(entry.getValue().getParent())) {
//                result = entry.getValue();
                result2 = entry.getKey();
                value2 = entry.getValue().getName();
                System.out.println("Id: " + result2);
                System.out.println("Category name: " + value2);
            }
        }


////        System.out.println(map.get(253498).getName());
//        Map<Integer, Integer> map1 = new HashMap<>();
//        map1.put(2, 4);
//        map1.put(3, 1);
//        map1.put(8, 1);
//        map1.put(9, 4);
//        map1.put(4, 3);
//        map1.put(6, 3);
//        map1.put(1, 4);
//        map1.put(7, 2);
//        map1.put(0, 2);
//
//        Integer value = 1;
//        Integer result = 0;
//        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            if(value.equals(entry.getValue())){
////                result = entry.getValue();
//                result = entry.getKey();
//                System.out.println(result);
//            }
//        }

        System.out.println();

//        int sum = 0;
//        for (int i = 0; i < allegroList.size(); i++) {
//            if (allegroList.get(i).getName().equals("Części samochodowe")) {
//                System.out.println(allegroList.get(i).getName());
//                sum++;
//                for (int j = 0; j < allegroList.size(); j++) {
//                    if (allegroList.get(i).getId() == allegroList.get(j).getParent()) {
//                        System.out.println("*" + allegroList.get(j).getName());
//                        sum++;
//                        for (int k = 0; k < allegroList.size(); k++) {
//                            if (allegroList.get(j).getId() == allegroList.get(k).getParent()) {
//                                System.out.println("**" + allegroList.get(k).getName());
//                                sum++;
//                                for (int l = 0; l < allegroList.size(); l++) {
//                                    if (allegroList.get(k).getId() == allegroList.get(l).getParent()) {
//                                        System.out.println("***" + allegroList.get(l).getName());
//                                        sum++;
//                                        for (int m = 0; m < allegroList.size(); m++) {
//                                            if (allegroList.get(l).getId() == allegroList.get(m).getParent()) {
//                                                System.out.println("****" + allegroList.get(m).getName());
//                                                sum++;
//
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//
//            }
//
//        }
//        System.out.println(sum);
    }
}

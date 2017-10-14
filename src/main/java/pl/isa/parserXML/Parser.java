package pl.isa.parserXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {


    public static void main(String[] args) {
        AllegroItem allegroItem;
        Map<Integer, AllegroItem> map = new HashMap<>();

//        List<AllegroItem> allegroList = new ArrayList<AllegroItem>();

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

                    allegroItem.setParentId(Integer.parseInt(eElement
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


//        Map<Integer, AllegroItem> tmpMap = new HashMap<>();
//        AllegroItem al = new AllegroItem();
//        Integer result_tmp = 0;
//
//        tmpMap = al.mojaFunkcja(mapM, result_tmp);
//
//        int i = 1;
//        for(AllegroItem as : tmpMap.values()) {
//            System.out.println((i++) + ": " + as.getName());
//        }
//
//        result_tmp = al.readData(tmpMap);
//        tmpMap = al.mojaFunkcja(mapM, result_tmp);
//
//        i = 1;
//        for(AllegroItem as : tmpMap.values()) {
//            System.out.println((i++) + ": " + as.getName());
//        }
//
//        result_tmp = al.readData(tmpMap);
//        tmpMap = al.mojaFunkcja(mapM, result_tmp);
//
//        i = 1;
//        for(AllegroItem as : tmpMap.values()) {
//            System.out.println((i++) + ": " + as.getName());
//        }
//
//        result_tmp = al.readData(mapM);
//        tmpMap = al.mojaFunkcja(mapM, result_tmp);
//
//        i = 1;
//        for(AllegroItem as : tmpMap.values()) {
//            System.out.println((i++) + ": " + as.getName());
//        }



        AllegroItem item1 = new AllegroItem();
        List<Integer> tmpList = new ArrayList<>();
        Integer result_tmp = 0;

//        display Categories
        tmpList = item1.allegroCategories(map, result_tmp);

//        display first childs of chosen category
        result_tmp = item1.readData(tmpList);
//        display first childs of chosen category
        tmpList = item1.allegroCategories(map, result_tmp);

//        display second childs of chosen category
        result_tmp = item1.readData(tmpList);
        tmpList = item1.allegroCategories(map, result_tmp);

//        display third childs of chosen category
        result_tmp = item1.readData(tmpList);
        tmpList = item1.allegroCategories(map, result_tmp);

        //        display third childs of chosen category
        result_tmp = item1.readData(tmpList);
        tmpList = item1.allegroCategories(map, result_tmp);

    }
}

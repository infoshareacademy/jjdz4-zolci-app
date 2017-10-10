package pl.isa.parserXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public class Parser {

    static Integer result_tmp2 = 0;
    static String value_tmp2 = "";
    static int i = 1;

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
        List<Integer> tmpList = new ArrayList<>();

        Integer result_tmp = 0;
        String value_tmp = value_tmp2;
//        Integer result_tmp2;
//        String value_tmp2;

        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result_tmp.equals(entry.getValue().getParent())) {
                result_tmp2 = entry.getKey();
                value_tmp2 = entry.getValue().getName();
                System.out.print("Id: " + result_tmp2);
                System.out.println(" : " + (i++) + " - Category name: " + value_tmp2);
                tmpList.add(result_tmp2);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWybierz numer kategorii: ");
        result_tmp = scanner.nextInt();
        result_tmp = tmpList.get(result_tmp - 1);
        tmpList.clear();
        i = 1;

        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result_tmp.equals(entry.getValue().getParent())) {
                result_tmp2 = entry.getKey();
                value_tmp2 = entry.getValue().getName();
                System.out.print("Id: " + result_tmp2);
                System.out.println(" : " + (i++) + " - Category name: " + value_tmp2);
                tmpList.add(result_tmp2);
            }
        }

        scanner = new Scanner(System.in);
        System.out.print("\nWybierz numer kategorii: ");
        result_tmp = scanner.nextInt();
        result_tmp = tmpList.get(result_tmp - 1);
        tmpList.clear();
        i = 1;

        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result_tmp.equals(entry.getValue().getParent())) {
                result_tmp2 = entry.getKey();
                value_tmp2 = entry.getValue().getName();
                System.out.print("Id: " + result_tmp2);
                System.out.println(" : " + (i++) + " - Category name: " + value_tmp2);
                tmpList.add(result_tmp2);
            }
        }

        scanner = new Scanner(System.in);
        System.out.print("\nWybierz numer kategorii: ");
        result_tmp = scanner.nextInt();
        result_tmp = tmpList.get(result_tmp - 1);
        tmpList.clear();
        i = 1;

        for (Map.Entry<Integer, AllegroItem> entry : map.entrySet()) {
            if (result_tmp.equals(entry.getValue().getParent())) {
                result_tmp2 = entry.getKey();
                value_tmp2 = entry.getValue().getName();
                System.out.print("Id: " + result_tmp2);
                System.out.println(" : " + (i++) + " - Category name: " + value_tmp2);
                tmpList.add(result_tmp2);
            }
        }





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

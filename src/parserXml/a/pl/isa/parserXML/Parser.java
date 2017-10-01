package parserXml.a.pl.isa.parserXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void main(String[] args) {
        AllegroItems allegroItem;
        List<AllegroItems> allegroList = new ArrayList<>();

        try {
            File inputFile = new File("/home/sony/projects/kategorie_xml/Allegro.xml");
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
                allegroItem = new AllegroItems();

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

                    allegroList.add(allegroItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (AllegroItems allegroItems : allegroList) {
            System.out.println("\nid: " + allegroItems.getId() + "\nName: " + allegroItems.getName() +
                    "\nParent: " + allegroItems.getParent() + "\nPosition: " + allegroItems.getPosition());
        }

//        for(int i=0; i < allegroList.size(); i++) {
//            for(int j=0; j < allegroList.size(); j++) {
//                if(allegroList.get(i).getId() == allegroList.get(j).getParent()) {
//                 System.out.println(allegroList.get(i).getName() + " - " + allegroList.get(j).getName());
//            }
//        }

//        for(int i=0; i < allegroList.size(); i++) {
//            for(int j=0; j < allegroList.size(); j++) {
//                for(int k=0; k < allegroList.size(); k++){
        //if(allegroList.get(i).getId() == allegroList.get(j).getParent()) {
        // System.out.println(allegroList.get(i).getName() + " - " + allegroList.get(j).getName());
        // }
//                    if(allegroList.get(i).getId() == allegroList.get(j).getParent()) {
//                       if(allegroList.get(j).getId() == allegroList.get(k).getParent()) {
//                           System.out.println(allegroList.get(i).getName() + " - "
//                                   + allegroList.get(j).getName() + " - "
//                                   + allegroList.get(k).getName());
//                       }
//                    }
//                }
//            }
    }

}

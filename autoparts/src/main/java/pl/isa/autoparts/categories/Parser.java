package pl.isa.autoparts.categories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;

class Parser {
    Logger logger = LoggerFactory.getLogger(Parser.class.getName());

    private AllegroItem allegroItem;

    Parser() {
        parse();
    }

    ArrayList<AllegroItem> getAllegroList() {
        return allegroList;
    }

    private ArrayList<AllegroItem> allegroList = new ArrayList<>();

    private void parse() {


        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputFile = classloader.getResourceAsStream("Allegro_cathegories_2016-02-13.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            try {
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("ns1:item");
                System.out.println("----------------------------");
                logger.info("Categories XML file loaded");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
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
                                .getTextContent().toLowerCase());

                        allegroItem.setParent(Integer.parseInt(eElement
                                .getElementsByTagName("ns1:catParent")
                                .item(0)
                                .getTextContent()));

                        allegroList.add(allegroItem);
                    }
                }
                logger.info("Allegro categories added");
            } catch (Exception e) {
                logger.error("Error in loading categories XML file");
            }
        } catch (Exception e) {
            logger.error("Error in loading categoriy from XML file(wrong data structure)");
            e.printStackTrace();
        }

    }
}
package pl.isa.autoparts.categories;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Parser {
//    private static final Logger logger = Logger.getLogger(Parser.class.getName());
    private AllegroItem allegroItem;

    public Parser() {
        parse();
    }

    public ArrayList<AllegroItem> getAllegroList() {
        return allegroList;
    }

    private ArrayList<AllegroItem> allegroList = new ArrayList<AllegroItem>();

    private void parse() {


        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputFile = classloader.getResourceAsStream("Allegro_cathegories_2016-02-13.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("ns1:item");
            System.out.println("----------------------------");
//            logger.info("Wczytano plik z kategoriami");
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
        } catch (Exception e) {
//            logger.severe("Błąd wczytywania pliku z kategoriami");
            e.printStackTrace();
        }

    }
}

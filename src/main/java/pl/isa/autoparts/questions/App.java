package pl.isa.autoparts.questions;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws IOException {
//
        XmlMapper mapper = new XmlMapper();


        InputStream activitiesStream = App.class.getClassLoader()
                .getResourceAsStream("questions.xml");
//                .getResourceAsStream("/home/sony/projects/java_projects/Myorigin/jjdz4-zolci-app/src/main/resources/questions.xml");
        Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");

        String file = String.valueOf(scanner);

//        String abc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
//                "<class>" +
//                "<grupa-pytan name=\"przod samochodu\">" +
//                "<pytanie>" +
//                "<id>1</id>" +
//                "<tresc>wyciek plynu</tresc>" +
//                "<awaria>" +
//                "<id>1</id>" +
//                "<tresc>wyciek z silnika</tresc>" +
//                "<czesc>" +
//                "<id>1</id>" +
//                "<nazwa>glowica</nazwa>" +
//                "</czesc>" +
//                "<czesc>" +
//                "<id>2</id>" +
//                "<nazwa>misa</nazwa>" +
//                "</czesc>" +
//                "<czesc>" +
//                "<id>3</id>" +
//                "<nazwa>uszczelka</nazwa>" +
//                "</czesc>" +
//                "</awaria>" +
//                "<awaria>" +
//                "<id>2</id>" +
//                "<tresc>wyciek z chlodnicy</tresc>" +
//                "<czesc>" +
//                "<id>1</id>" +
//                "<nazwa>chlodnica</nazwa>" +
//                "</czesc>" +
//                "</awaria>" +
//                "</pytanie>" +
//                "</grupa-pytan>" +
//                "</class>";

        XmlMapper xmlMapper = new XmlMapper();
//        TopClass topClass1 = xmlMapper.readValue(file, TopClass.class);

//        System.out.println(xmlMapper.readValue(file, TopClass.class));

//        System.out.println(topClass1.getRootClass().get(0).getQuestions().get(0).getDescripton());

        while (scanner.hasNext()) {

            System.out.println(scanner.next());

        }
    }
}

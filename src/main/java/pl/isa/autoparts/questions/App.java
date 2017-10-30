package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {
        Functions functions = new Functions();

        InputStream activitiesStream = App.class.getClassLoader()
                .getResourceAsStream("questions.xml");

        String file = functions.getStringFromInputStream(activitiesStream);
        XmlMapper xmlMapper = new XmlMapper();
        TopClass topClass = xmlMapper.readValue(file, TopClass.class);

        functions.giveQuestionGrup(topClass);
    }
}

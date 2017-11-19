package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Questionary {
    List<String> lista = new ArrayList<>();

    public void questionOptions() throws IOException {
        Functions functions = new Functions();
//        Logger logger = LoggerFactory.getLogger(Questionary.class.getName());


        InputStream activitiesStream = Questionary.class.getClassLoader()
                .getResourceAsStream("questions.xml");

        String file = functions.getStringFromInputStream(activitiesStream);
        XmlMapper xmlMapper = new XmlMapper();
        TopClass topClass = xmlMapper.readValue(file, TopClass.class);
//        logger.info("XML is mapped correctly");

        functions.giveQuestionGrup(topClass.getGrupaPytan(), true);

//        Questions questions = functions.giveQuestionGrup(topClass.getGrupaPytan(), true);
//        if (questions.isEmpty) {
//            return;
//        }
//


        lista.addAll(functions.getLista());
        functions.clearList();
    }
}

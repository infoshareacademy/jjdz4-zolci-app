package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;

public class Questionary {
    List<String> lista = new ArrayList<>();

    public void questionOptions() throws IOException {
        Functions functions = new Functions();
//        Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
//
////        Logger logger = LoggerFactory.getLogger(Questionary.class);
//
//        logger.info("\nThis is how you configure Log4J with SLF4J");



        InputStream activitiesStream = Questionary.class
                .getClassLoader()
                .getResourceAsStream("questions.xml");

        String file = functions.getStringFromInputStream(activitiesStream);
        XmlMapper xmlMapper = new XmlMapper();
        TopClass topClass = xmlMapper.readValue(file, TopClass.class);
//        logger.info("XML is mapped correctly");


        List<BreakDown> breakDowns;
        List<Parts> parts;
        List<Question> questionsGroup = functions.giveQuestionGrup(topClass.getGrupaPytan());
        if (questionsGroup.isEmpty()) {
            return;
        } else {
            breakDowns = functions.giveQuestion(questionsGroup);
        }

        if (breakDowns.isEmpty()) {
            return;
        } else {
            parts = functions.giveBreakDown(breakDowns);
        }

        if (parts.isEmpty()){
            return;
        }else {
            functions.giveParts(parts);
        }

        lista.addAll(functions.getLista());
        functions.clearList();
    }
}

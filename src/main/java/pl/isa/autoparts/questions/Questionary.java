package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Questionary {
    private List<String> lista = new ArrayList<>();
    private List<String> propositionsList = new ArrayList<>();
    public void questionOptions() throws IOException {
        Functions functions = new Functions();
//        Logger logger = LoggerFactory.getLogger(Questionary.class.getName());

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
        propositionsList = functions.getLista();
        functions.clearList();
    }
    public List<String> getPropositionsList(){
        return propositionsList;
    }
}

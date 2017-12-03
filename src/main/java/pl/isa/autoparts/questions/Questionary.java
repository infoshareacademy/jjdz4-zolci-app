package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionary {
    private List<String> stringList = new ArrayList<>();
    public void questionOptions() throws IOException {
        Functions functions = new Functions();

        List<BreakDown> breakDowns;
        List<Parts> parts;
        List<Question> questionsGroup = null;
        TopClass topClass = null;
        XmlMapper xmlMapper = null;
        String file = null;

        Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
        logger.info("finding autoparts by questions module");



        try {
            InputStream activitiesStream = Questionary.class
                    .getClassLoader()
                    .getResourceAsStream("questions.xml");
            file = functions.getStringFromInputStream(activitiesStream);
            xmlMapper = new XmlMapper();

            topClass = xmlMapper.readValue(file, TopClass.class);
            questionsGroup = functions.giveQuestionGrup(topClass.getGrupaPytan());
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xml\"");
            return;
        }
        logger.info("XML is mapped correctly");



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

        if (parts.isEmpty()) {
            return;
        } else {
            functions.giveParts(parts);
            if(functions.getLista().isEmpty()){
                logger.debug("Nie poprawne wywołanie działań z metody \"functions\"");
            }else {
                logger.debug("Poprawne wywołanie działań z metody \"functions\"");
            }
        }

        stringList.addAll(functions.getLista());
        return;
    }


    public List<String> getStringList(){
        return stringList;
    }
}

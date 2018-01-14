package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionary {
    public static String myFind;

    Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
    private List<String> stringList = new ArrayList<>();
    Functions functions = new Functions();

    List<Question> questionsGroup;
//    List<Question> questionsGroupWeb;
    List<BreakDown> breakDowns;
    List<Parts> parts;
    TopClass topClass;

    public TopClass init() throws IOException {

        logger.info("finding autoparts by questions module");

        try {
            InputStream activitiesStream = Questionary.class
                    .getClassLoader()
                    .getResourceAsStream("questions.xml");
            String file = functions.getStringFromInputStream(activitiesStream);
            XmlMapper xmlMapper = new XmlMapper();

            topClass = xmlMapper.readValue(file, TopClass.class);
//            questionsGroup = functions.giveQuestionGrup(topClass.getGrupaPytan());
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xml\"");
            return null;
        }

        logger.info("XML is mapped correctly");
        return topClass;
    }

    /**                    */
    public List<Question> tryWeb(String checkValue) throws IOException {
        myFind = checkValue;
        questionsGroup = functions.giveQuestionGrupWeb(topClass.getGrupaPytan(), true, checkValue); // sprawdzic
        return questionsGroup;
    }

    public List<BreakDown> breakDownsWeb(String checkValue) throws IOException {
        questionsGroup = functions.giveQuestionGrupWeb(topClass.getGrupaPytan(), true, myFind);
        List<BreakDown> breakDowns = functions.giveQuestionWeb(questionsGroup, true, checkValue);
//        BreakDown breakDown = functions.giveQuestionWeb(questionsGroup, true, checkValue);

        return breakDowns;
    }




    /**                    */



    public void questionGroupFunction() throws IOException {
        if (questionsGroup.isEmpty()) {
            return;
        } else {
            breakDowns = functions.giveQuestion(questionsGroup);
        }
    }

    public void breakDownFunction(List<BreakDown> breakDowns) throws IOException {
        if (breakDowns.isEmpty()) {
            return;
        } else {
            parts = functions.giveBreakDown(breakDowns);
        }
    }
    
    public void partsFunction(List<Parts> parts) {
        if (parts.isEmpty()) {
            return;
        } else {
            functions.giveParts(parts);
            if (functions.getLista().isEmpty()) {
                logger.debug("Nie poprawne wywołanie działań z metody \"functions\"");
            } else {
                logger.debug("Poprawne wywołanie działań z metody \"functions\"");
            }
        }
        stringList.addAll(functions.getLista());
        return;
    }
    

    public void questionOptions() throws IOException {

        init();
        questionsGroup = functions.giveQuestionGrup(topClass.getGrupaPytan()); // sprawdzic
        questionGroupFunction();
        breakDownFunction(breakDowns);
        partsFunction(parts);
    }


    public List<String> getStringList() {
        return stringList;
    }
}
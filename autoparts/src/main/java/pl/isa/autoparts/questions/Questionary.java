package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionary {
//    public static String myFind;

    Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
    private List<String> stringList = new ArrayList<>();
    Functions functions = new Functions();

    List<Question> questionsGroup;
    List<BreakDown> breakDowns;
    List<Parts> parts;
    TopClass topClass;

    FunctionsWeb functionsWeb = new FunctionsWeb();

    public TopClass init() throws IOException {
        logger.info("finding autoparts by questions module");

        try {
            InputStream activitiesStream = Questionary.class
                    .getClassLoader()
                    .getResourceAsStream("questions.xml");
            String file = functions.getStringFromInputStream(activitiesStream);
            XmlMapper xmlMapper = new XmlMapper();

            topClass = xmlMapper.readValue(file, TopClass.class);
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xml\"");
            return null;
        }
        logger.info("XML is mapped correctly");
        return topClass;
    }


    /** nowa wersja    */

    public List<Question> groupJee(String checkValue) throws IOException {
        init();
        questionsGroup = functionsWeb.giveQuestionGrupWeb(topClass.getGrupaPytan(), checkValue); // sprawdzic
        return questionsGroup;
    }

    public List<BreakDown> breakDownsJee(String checkValue) throws IOException {
        breakDowns = functionsWeb.giveQuestionWeb(questionsGroup, checkValue);
        return breakDowns;
    }

    public List<Parts> partsJee(String checkValue) throws IOException {
        for(BreakDown breakDownTmp : breakDowns){
            if(breakDownTmp.getDescription().equals(checkValue)){
                return breakDownTmp.getParts();
            }
        }
        return null;
    }

    /**     koniec nowej wersji    */



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
                logger.debug("Uncorrectly invoke from \"functions\"");
            } else {
                logger.debug("Correctly invoke from \"functions\"");
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
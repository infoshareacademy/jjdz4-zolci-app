package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionary {

    Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
    private List<String> stringList = new ArrayList<>();
    ConsoleFunctions consoleFunctions = new ConsoleFunctions();

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
            String file = consoleFunctions.getStringFromInputStream(activitiesStream);
            XmlMapper xmlMapper = new XmlMapper();

            topClass = xmlMapper.readValue(file, TopClass.class);
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xml\"");
            return null;
        }
        logger.info("XML is mapped correctly");
        return topClass;
    }


    public List<Question> groupJee(String checkValue) throws IOException {
        init();
        questionsGroup = functionsWeb.giveQuestionGrupWeb(topClass.getGrupaPytan(), checkValue);
        logger.info("JEE: checkValue find correctly for tag \'questions\'");
        return questionsGroup;
    }

    public List<BreakDown> breakDownsJee(String checkValue) throws IOException {
        breakDowns = functionsWeb.giveQuestionWeb(questionsGroup, checkValue);
        return breakDowns;
    }

    public List<Parts> partsJee(String checkValue) throws IOException {
        for (BreakDown breakDownCount : breakDowns) {
            if (breakDownCount.getDescription().equals(checkValue)) {
                logger.info("JEE: checkValue find correctly for tag \'breakDown\'");
                return breakDownCount.getParts();
            }
        }
        return null;
    }


    public void questionGroupFunction() throws IOException {
        if (questionsGroup.isEmpty()) {
            return;
        } else {
            breakDowns = consoleFunctions.giveQuestion(questionsGroup);
        }
    }

    public void breakDownFunction(List<BreakDown> breakDowns) throws IOException {
        if (breakDowns.isEmpty()) {
            return;
        } else {
            parts = consoleFunctions.giveBreakDown(breakDowns);
        }
    }

    public void partsFunction(List<Parts> parts) {
        if (parts.isEmpty()) {
            return;
        } else {
            consoleFunctions.giveParts(parts);
            if (consoleFunctions.getLista().isEmpty()) {
                logger.debug("Uncorrectly invoke from \"consoleFunctions\"");
            } else {
                logger.debug("Correctly invoke from \"consoleFunctions\"");
            }
        }
        stringList.addAll(consoleFunctions.getLista());
        return;
    }

    public void questionOptions() throws IOException {
        init();
        questionsGroup = consoleFunctions.chooseQuestionGroup(topClass.getGrupaPytan());
        questionGroupFunction();
        breakDownFunction(breakDowns);
        partsFunction(parts);
    }

    public List<String> getStringList() {
        return stringList;
    }
}
package pl.isa.autoparts.questions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionary {

    private Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
    private List<String> stringList = new ArrayList<>();
    private InitQuestionsParser initialingQuestionsParser = new InitQuestionsParser();
    private ConsoleFunctions consoleFunctions = new ConsoleFunctions();

    private List<Question> questionsGroup;
    private List<BreakDown> breakDowns;
    private List<Parts> parts;

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
        TopClass topClass = initialingQuestionsParser.init();
        questionsGroup = consoleFunctions.chooseQuestionGroup(topClass.getGrupaPytan());
        questionGroupFunction();
        breakDownFunction(breakDowns);
        partsFunction(parts);
    }

    public List<String> getStringList() {
        return stringList;
    }
}
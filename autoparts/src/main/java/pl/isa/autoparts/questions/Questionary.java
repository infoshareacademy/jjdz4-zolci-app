package pl.isa.autoparts.questions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionary {

    private Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
    private ConsoleFunctions consoleFunctions = new ConsoleFunctions();
    private List<String> partsListForLink = new ArrayList<>();

    TopClass topClass = new TopClass();
    private List<Question> questionsGroup;
    private List<BreakDown> breakDowns;
    private List<Parts> parts;

    public Questionary() throws IOException {
    }

    public void getQuestions() throws IOException {
        if (questionsGroup.isEmpty()) {
            return;
        } else {
            breakDowns = consoleFunctions.chooseQuestion(questionsGroup);
        }
    }

    public void getBreakDown(List<BreakDown> breakDowns) throws IOException {
        if (breakDowns.isEmpty()) {
            return;
        } else {
            parts = consoleFunctions.chooseBreakDown(breakDowns);
        }
    }

    public void getParts(List<Parts> parts) {
        if (parts.isEmpty()) {
            return;
        } else {
            consoleFunctions.chooseParts(parts);
            if (consoleFunctions.getPartsList().isEmpty()) {
                logger.debug("Uncorrectly invoke from \"consoleFunctions\"");
            } else {
                logger.debug("Correctly invoke from \"consoleFunctions\"");
            }
        }
        partsListForLink.addAll(consoleFunctions.getPartsList());
        return;
    }

    public void questionOptions() throws IOException {
        InitQuestionsParser initQuestionsParser = new InitQuestionsParser(topClass);
        topClass = initQuestionsParser.getTopClass();
        questionsGroup = consoleFunctions.chooseQuestionGroup(topClass.getGrupaPytan());
        getQuestions();
        getBreakDown(breakDowns);
        getParts(parts);
    }

    public List<String> getPartsListForLink() {
        return partsListForLink;
    }
}
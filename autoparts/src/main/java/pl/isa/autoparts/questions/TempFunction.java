package pl.isa.autoparts.questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TempFunction {
    private Logger logger = LoggerFactory.getLogger(Questionary.class.getName());
    private ConsoleFunctions consoleFunctions = new ConsoleFunctions();
    private List<String> partsListForLink = new ArrayList<>();

    TopClass topClass = new TopClass();
    private List<Question> questionsGroup;
    private List<BreakDown> breakDowns;
    private List<Parts> parts;

    public void function() throws IOException {
        InitQuestionsParser initQuestionsParser = new InitQuestionsParser(topClass);
        this.topClass = initQuestionsParser.getTopClass();


    }

}

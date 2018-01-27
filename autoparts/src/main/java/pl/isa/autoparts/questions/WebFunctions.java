package pl.isa.autoparts.questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class WebFunctions {
    TopClass topClass = new TopClass();

    private Logger logger = LoggerFactory.getLogger(WebFunctions.class.getName());
    private InitQuestionsParser initQuestionsParser = new InitQuestionsParser(topClass);
    private List<Question> questionsGroup;
    private List<BreakDown> breakDowns;

    public WebFunctions() throws IOException {
    }

    protected List<Question> chooseQuestionGrup(List<QuestionGroup> questions, String checkValue)
            throws IOException {
        for (QuestionGroup question : questions) {
            if (question.getName().equals(checkValue)) {
                return question.getQuestions();
            }
        }
        return null;
    }

    protected List<BreakDown> chooseQuestion(List<Question> questions, String checkValue) throws IOException {
        for (Question question : questions) {
            if (question.getDescripton().equals(checkValue)) {
                logger.debug("Web: checkValue find correctly for tag \'breakDown\'");
                return question.getBreakDown();
            }
        }
        return null;
    }

    public List<Question> findQuestion(String checkValue) throws IOException {
        topClass = initQuestionsParser.getTopClass();
        questionsGroup = chooseQuestionGrup(topClass.getGrupaPytan(), checkValue);
        logger.debug("JEE: checkValue find correctly for tag \'questions\'");
        return questionsGroup;
    }

    public List<BreakDown> findBreakDowns(String checkValue) throws IOException {
        breakDowns = chooseQuestion(questionsGroup, checkValue);
        return breakDowns;
    }

    public List<Parts> findParts(String checkValue) throws IOException {
        for (BreakDown breakDownCount : breakDowns) {
            if (breakDownCount.getDescription().equals(checkValue)) {
                logger.debug("JEE: checkValue find correctly for tag \'breakDown\'");
                return breakDownCount.getParts();
            }
        }
        return null;
    }
}

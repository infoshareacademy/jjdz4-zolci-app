package pl.isa.autoparts.questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class FunctionsWeb {
    private Logger logger = LoggerFactory.getLogger(FunctionsWeb.class.getName());
    private InitQuestionsParser initQuestionsParser = new InitQuestionsParser();
    private List<Question> questionsGroup;
    private List<BreakDown> breakDowns;

    protected List<Question> giveQuestionGrupWeb(List<QuestionGroup> questions, String checkValue)
            throws IOException {
        for (QuestionGroup question : questions) {
            if (question.getName().equals(checkValue)) {
                return question.getQuestions();
            }
        }
        return null;
    }

    protected List<BreakDown> giveQuestionWeb(List<Question> questions, String checkValue) throws IOException {
        for (Question question : questions) {
            if (question.getDescripton().equals(checkValue)) {
                logger.debug("JEE: checkValue find correctly for tag \'breakDown\'");
                return question.getBreakDown();
            }
        }
        return null;
    }

    public List<Question> groupJee(String checkValue) throws IOException {
        TopClass topClass = initQuestionsParser.init();
        questionsGroup = giveQuestionGrupWeb(topClass.getGrupaPytan(), checkValue);
        logger.debug("JEE: checkValue find correctly for tag \'questions\'");
        return questionsGroup;
    }

    public List<BreakDown> breakDownsJee(String checkValue) throws IOException {
        breakDowns = giveQuestionWeb(questionsGroup, checkValue);
        return breakDowns;
    }

    public List<Parts> partsJee(String checkValue) throws IOException {
        for (BreakDown breakDownCount : breakDowns) {
            if (breakDownCount.getDescription().equals(checkValue)) {
                logger.debug("JEE: checkValue find correctly for tag \'breakDown\'");
                return breakDownCount.getParts();
            }
        }
        return null;
    }
}

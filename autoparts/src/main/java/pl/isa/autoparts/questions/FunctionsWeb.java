package pl.isa.autoparts.questions;

import java.io.IOException;
import java.util.List;

public class FunctionsWeb {


    protected List<Question> giveQuestionGrupWeb(List<QuestionGroup> questions, String checkValue)
            throws IOException {

        for (QuestionGroup question : questions) {
            if (question.getName().equals(checkValue)) {
                return question.getQuestions();
            }
        }

        return null;
    }

    protected  List<BreakDown> giveQuestionWeb(List<Question> questions, String checkValue) throws IOException {

        for(Question question : questions){
            if(question.getDescripton().equals(checkValue))
                return question.getBreakDown();
        }
        return null;
    }

}

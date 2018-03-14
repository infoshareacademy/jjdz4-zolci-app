package pl.isa.autopartsJee.linkGenerating.dao;

import pl.isa.autoparts.questions.*;
import pl.isa.autopartsJee.linkGenerating.WebLinkGenerator;
import pl.isa.autopartsJee.linkGenerating.dao.TreeOperationsRepositoryDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class FindQuestionRepository {

    @EJB
    private TreeOperationsRepositoryDao dao;

    public List<String> getQuestiongroupRepository() {
        TopClass topClass = new TopClass();
        try {
            InitQuestionsParser initQuestionsParser = new InitQuestionsParser(topClass);
            topClass = initQuestionsParser.getTopClass();
        } catch (IOException e) {

        }
        List<String> questionaryName = new ArrayList<>();

        for (QuestionGroup questionGroup : topClass.getGrupaPytan()) {
            questionaryName.add(questionGroup.getName());
        }
        return questionaryName;
    }

    public List<String> getQuestionRepository(String getParam, WebFunctions webFunctions) {
        try {
            List<Question> myQuestions = webFunctions.findQuestion(getParam);
            List<String> tempQuestion = new ArrayList<>();

            for (Question tmpQuestion : myQuestions) {
                tempQuestion.add(tmpQuestion.getDescripton());
            }
            return tempQuestion;
        } catch (IOException e) {
            return null;
        }
    }

    public List<String> getBreakDownsRepository(String getParam, WebFunctions webFunctions){
        try{
            List<BreakDown> breakDown = webFunctions.findBreakDowns(getParam);
            List<String> breakDownView = new ArrayList<>();

            for (BreakDown breakDownTmp : breakDown) {
                breakDownView.add(breakDownTmp.getDescription());
            }
            return breakDownView;
        } catch (IOException e){
            return null;
        }
    }

    public Map<String, String> getPartsRepository(String getParam, WebFunctions webFunctions){
        try{
            List<Parts> parts = webFunctions.findParts(getParam);
            WebLinkGenerator webLinkGenerator = new WebLinkGenerator();
            Map<String, String> tempMap = new HashMap<>();

            for (Parts partsTmp : parts) {
                tempMap.put(webLinkGenerator.generateLink(partsTmp.getPart(), dao.getRepository()),
                        partsTmp.getPart());
            }
            return tempMap;
        } catch (IOException e) {
            return null;
        }

    }
}

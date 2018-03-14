package pl.isa.autopartsJee.linkGenerating.dao;

import pl.isa.autoparts.questions.WebFunctions;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

@Local
public interface FindQuestionDao {

    List<String> getQuestiongroup();

    List<String> getQuestionDao(String param, WebFunctions webFunctions);

    List<String> getBreakDownDao(String getParam, WebFunctions webFunctions);

    Map<String, String> getPartsDao(String getParam, WebFunctions webFunctions);
}


























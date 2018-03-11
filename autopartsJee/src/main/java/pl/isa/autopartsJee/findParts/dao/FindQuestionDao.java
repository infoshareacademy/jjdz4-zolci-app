package pl.isa.autopartsJee.findParts.dao;

import pl.isa.autoparts.questions.WebFunctions;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

@Local
public interface FindQuestionDao {

    public List<String> getQuestiongroup();

    public List<String> getQuestionDao(String param, WebFunctions webFunctions);

    public List<String> getBreakDownDao(String getParam, WebFunctions webFunctions);

    public Map<String, String> getPartsDao(String getParam, WebFunctions webFunctions);
}


























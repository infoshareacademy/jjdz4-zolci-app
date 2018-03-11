package pl.isa.autopartsJee.findParts.dao;

import pl.isa.autoparts.questions.WebFunctions;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class FindQuestionDaoBean implements FindQuestionDao {

    @Inject
    FindQuestionRepository findQuestionRepository;

    @Override
    public List<String> getQuestiongroup() {
        return findQuestionRepository.getQuestiongroupRepository();
    }

    @Override
    public List<String> getQuestionDao(String param, WebFunctions webFunctions) {
        System.out.println(param + " dao");
        return findQuestionRepository.getQuestionRepository(param, webFunctions);
    }

    @Override
    public List<String> getBreakDownDao(String getParam, WebFunctions webFunctions) {
        return findQuestionRepository.getBreakDownsRepository(getParam, webFunctions);
    }

    @Override
    public Map<String, String> getPartsDao(String getParam, WebFunctions webFunctions) {
        return findQuestionRepository.getPartsRepository(getParam, webFunctions);
    }

}

package pl.isa.parseQuestionsXML;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement (localName = "class") public class TopClass {
    @JacksonXmlProperty(localName = "grupa-pytan")
    List<QuestionGroup> questionGroup = new ArrayList<QuestionGroup>();

    public TopClass() {
    }

    public List<QuestionGroup> getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(List<QuestionGroup> questionGroup) {
        this.questionGroup = questionGroup;
    }

    public TopClass(List<QuestionGroup> questionGroup) {
        this.questionGroup = questionGroup;
    }





}

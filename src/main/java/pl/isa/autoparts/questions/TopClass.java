package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "class")
public class TopClass {

@JacksonXmlElementWrapper(localName = "class")
    private List<QuestionGroup> rootClass;

    public List<QuestionGroup> getRootClass() {
        return rootClass;
    }

    public void setRootClass(List<QuestionGroup> rootClass) {
        this.rootClass = rootClass;
    }
}

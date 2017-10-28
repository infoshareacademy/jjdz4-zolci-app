package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "class")
public class TopClass {

//    @JacksonXmlProperty(localName = "grupa-pytan")
    @JacksonXmlElementWrapper(localName = "grupa-pytan")
    private List<QuestionGroup> rootClass;

    public List<QuestionGroup> getRootClass() {
        return rootClass;
    }

    public void setRootClass(List<QuestionGroup> rootClass) {
        this.rootClass = rootClass;
    }


}

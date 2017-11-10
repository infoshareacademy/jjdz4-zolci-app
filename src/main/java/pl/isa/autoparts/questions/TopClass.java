package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "class")
public final class TopClass {

//    @JacksonXmlProperty(localName = "grupa-pytan")

    @JacksonXmlProperty(localName = "grupa-pytan")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<QuestionGroup> grupaPytan;


    public List<QuestionGroup> getGrupaPytan() {
        return grupaPytan;
    }

    public void setGrupaPytan(List<QuestionGroup> grupaPytan) {
        this.grupaPytan = grupaPytan;
    }


}

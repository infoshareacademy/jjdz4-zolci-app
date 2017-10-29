package pl.isa.autoparts.questions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "class")
public class TopClass {

//    @JacksonXmlProperty(localName = "grupa-pytan")

    //@JacksonXmlElementWrapper(localName = "grupa-pytan" , useWrapping = true)
    @JacksonXmlProperty(localName = "grupa-pytan")
    private QuestionGroup[] grupaPytan;


    public QuestionGroup[] getGrupaPytan() {
        return grupaPytan;
    }

    public void setGrupaPytan(QuestionGroup[] grupaPytan) {
        this.grupaPytan = grupaPytan;
    }


}

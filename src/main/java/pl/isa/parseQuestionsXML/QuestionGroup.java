package pl.isa.parseQuestionsXML;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement (localName = "class") public class QuestionGroup {
    @JacksonXmlElementWrapper(localName = "grupa-pytan", useWrapping = false)


    List<String> question = new ArrayList<String>();
    String name;




}

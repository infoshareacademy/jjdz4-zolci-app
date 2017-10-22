package pl.isa.parseQuestionsXML;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Question {
    @JacksonXmlProperty(localName = "id")
            String id;
    @JacksonXmlProperty(localName = "tresc")
            String text;
    @JacksonXmlProperty(localName = "awaria")
            List<Fault> faults = new ArrayList<Fault>();

    public Question() {
    }

    public Question(String id, String text, List<Fault> faults) {
        this.id = id;
        this.text = text;
        this.faults = faults;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Fault> getFaults() {
        return faults;
    }

    public void setFaults(List<Fault> faults) {
        this.faults = faults;
    }
}

package pl.isa.parseQuestionsXML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Fault {
    @JacksonXmlProperty(localName = "id")
        String id;
    @JacksonXmlProperty(localName = "tresc")
        String text;
    @JacksonXmlProperty(localName = "czesc")
        List<Part> parts = new ArrayList<Part>();

    public Fault() {
    }

    public Fault(String id, String text, List<Part> parts) {
        this.id = id;
        this.text = text;
        this.parts = parts;
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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}

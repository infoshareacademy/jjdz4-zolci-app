package pl.isa.parseQuestionsXML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Part {
    @JacksonXmlProperty(localName = "id")
        String id;
    @JacksonXmlProperty(localName = "nazwa")
        String name;

    public Part() {
    }

    public Part(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

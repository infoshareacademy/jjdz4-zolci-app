package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class BreakDown {

    @JacksonXmlProperty(localName = "id")
    private int id;

    @JacksonXmlProperty(localName = "tresc")
    private String description;

    @JacksonXmlElementWrapper(localName = "czesc")
    private List<Parts> parts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }
}


//<awaria>
//<id>1</id>
//<tresc>panel z kontrolkami</tresc>
//<czesc>
//<id>1</id>
//<nazwa>bezpiecznik</nazwa>
//</czesc>
//</awaria>
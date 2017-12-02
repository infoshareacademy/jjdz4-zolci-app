package pl.isa.web.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Parts {

    @JacksonXmlProperty(localName = "id")
    private int id;

    @JacksonXmlProperty(localName = "nazwa")
    private String part;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}


//<czesc>
//<id>1</id>
//<nazwa>bezpiecznik</nazwa>
//</czesc>
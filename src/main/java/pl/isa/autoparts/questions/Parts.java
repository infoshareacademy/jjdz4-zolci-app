package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Parts {

    @JacksonXmlProperty(localName = "id")
    private int id;

    @JacksonXmlProperty(localName = "nazwa")
    private String part;


}


//<czesc>
//<id>1</id>
//<nazwa>bezpiecznik</nazwa>
//</czesc>
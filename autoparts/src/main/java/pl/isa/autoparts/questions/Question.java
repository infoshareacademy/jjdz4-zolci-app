package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public final class Question {
    @JacksonXmlProperty(localName = "id")
    private int id;

    @JacksonXmlProperty(localName = "opis")
    private String descripton;

    @JacksonXmlProperty(localName = "awaria")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<BreakDown> breakDown;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public List<BreakDown> getBreakDown() {
        return breakDown;
    }

    public void setBreakDown(List<BreakDown> breakDown) {
        this.breakDown = breakDown;
    }

}

package pl.isa.autoparts.questions;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class QuestionGroup {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;

    @JacksonXmlElementWrapper(localName = "pytanie", useWrapping = false)
    private List<Question> questions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

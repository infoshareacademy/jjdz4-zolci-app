package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.tools.ConvertInputStreamToString;

import java.io.IOException;
import java.io.InputStream;

public class InitQuestionsParser {
    private Logger logger = LoggerFactory.getLogger(InitQuestionsParser.class.getName());
    private ConvertInputStreamToString convertInputStreamToString = new ConvertInputStreamToString();
    private TopClass topClass;

    public InitQuestionsParser(TopClass topClass) throws IOException {
        this.topClass = topClass;
        logger.info("finding autoparts by questions module");
        try {
            InputStream activitiesStream = Questionary.class
                    .getClassLoader()
                    .getResourceAsStream("questions.xml");
            String file = convertInputStreamToString.getStringFromInputStream(activitiesStream);
            XmlMapper xmlMapper = new XmlMapper();

            this.topClass = xmlMapper.readValue(file, TopClass.class);
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xml\"");
        }
        logger.debug("XML is mapped correctly");
    }

    public TopClass getTopClass() {
        return topClass;
    }
}

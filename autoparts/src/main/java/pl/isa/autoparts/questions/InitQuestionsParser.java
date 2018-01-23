package pl.isa.autoparts.questions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.tools.ConvertInStreamToString;

import java.io.IOException;
import java.io.InputStream;

public class InitQuestionsParser {
    Logger logger = LoggerFactory.getLogger(InitQuestionsParser.class.getName());
    ConvertInStreamToString convertInStreamToString = new ConvertInStreamToString();

    public TopClass init() throws IOException {
        TopClass topClass;
        logger.info("finding autoparts by questions module");
        try {
            InputStream activitiesStream = Questionary.class
                    .getClassLoader()
                    .getResourceAsStream("questions.xml");
            String file = convertInStreamToString.getStringFromInputStream(activitiesStream);
            XmlMapper xmlMapper = new XmlMapper();

            topClass = xmlMapper.readValue(file, TopClass.class);
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xml\"");
            return null;
        }
        logger.debug("XML is mapped correctly");

        return topClass;
    }
}

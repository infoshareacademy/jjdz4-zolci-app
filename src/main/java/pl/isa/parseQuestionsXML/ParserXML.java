package pl.isa.parseQuestionsXML;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;

public class ParserXML {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new XmlMapper();

    //    TopClass topClass = objectMapper.readValue(

             //   StringUtils.toEncodedString(Files.readAllBytes(Paths.get("questions.xml")), StandardCharsets.UTF_8),

             //   TopClass.class);

    //    System.out.println(topClass);

    }

}

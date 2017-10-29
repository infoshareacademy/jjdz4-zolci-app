package pl.isa.autoparts.questions;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args) throws IOException {
//
//        XmlMapper mapper = new XmlMapper();
//        XmlMapper xmlMapper = new XmlMapper();
//        File file = new File("out.xml");
//        file.delete();
//
//        xmlMapper.writeValue(new File("out.xml"), prepareTopClass());


        InputStream activitiesStream = App.class.getClassLoader()
                .getResourceAsStream("questions.xml");
//                .getResourceAsStream("/home/sony/projects/java_projects/Myorigin/jjdz4-zolci-app/src/main/resources/questions.xml");
       // Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");


        String file = getStringFromInputStream(activitiesStream);
        XmlMapper xmlMapper = new XmlMapper();

        System.out.println(file);
        TopClass topClass1 = xmlMapper.readValue(file, TopClass.class);



//        System.out.println(xmlMapper.readValue(file, TopClass.class));

        System.out.println(topClass1.getGrupaPytan().get(0).getQuestions().get(0).getDescripton());


    }



//    public static TopClass prepareTopClass() {
//
//        TopClass tc = new TopClass();
//
//
//        QuestionGroup questionGroup1 = new QuestionGroup();
//        questionGroup1.setId(1);
//        questionGroup1.setName("name");
//        List<Question>  qg1questions = new ArrayList<>();
//        Question singleQ = new Question();
//        singleQ.setDescripton("des");
//        singleQ.setId(44);
//        qg1questions.add(singleQ);
//
//        questionGroup1.setQuestions(qg1questions);
//
////        QuestionGroup[] questions = new QuestionGroup[]{questionGroup1};
//        List<QuestionGroup> questions = new ArrayList<>();
//        questions.add(questionGroup1);
//
//        tc.setGrupaPytan(questions);
//
//
//        return tc;
//    }

    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

}

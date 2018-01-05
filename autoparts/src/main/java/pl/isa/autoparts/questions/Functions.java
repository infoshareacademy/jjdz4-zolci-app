package pl.isa.autoparts.questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.TextMenu;
import pl.isa.autoparts.categories.TreeOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Functions {
    private Scanner sc = new Scanner(System.in);
    Logger logger = LoggerFactory.getLogger(Functions.class.getName());

//    public Functions(){
//        logger.info("");
//    }

    private List<String> lista = new ArrayList<>();

    TreeOperations treeOperations = new TreeOperations();
    TextMenu textMenu = new TextMenu();

    protected List<Question> giveQuestionGrup(List<QuestionGroup> questions) throws IOException {
        logger.info("Start Function");

        for (Iterator<QuestionGroup> iterator = questions.iterator(); iterator.hasNext(); ) {
            QuestionGroup questionGroup = iterator.next();
            if (questionGroup.getQuestions().isEmpty()) {
                break;
            }
            System.out.print("Czy awaria dotyczy: " +
                    questionGroup.getName() +
                    "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

            if (sc.next().equals("y")) {
                return questionGroup.getQuestions();
            } else if (iterator.hasNext()) {
                System.out.println("\nNastępna opcja: \n");
            }
        }
        System.out.println("\nNie wybrałeś żadnej kategorii!\n\n\n");
        textMenu.options();
        return null;
    }

    protected List<BreakDown> giveQuestion(List<Question> questions) throws IOException {

        for (Iterator<Question> iterator = questions.iterator(); iterator.hasNext(); ) {
            Question question = iterator.next();
            if (question.getBreakDown().isEmpty()) {
                break;
            }
            System.out.print("\nCzy awaria dotyczy: " +
                    question.getDescripton() +
                    "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

            if (sc.next().equals("y")) {
                return question.getBreakDown();
            }else if (iterator.hasNext())
                System.out.println("\nNastępna opcja: ");
        }
        System.out.println("\nNie wybrałeś żadnej kategorii!\n\n\n");
        textMenu.options();
        return null;
    }

    protected List<Parts> giveBreakDown(List<BreakDown> questions) throws IOException {
        boolean breakDownIsNotDetected = true;

        for (Iterator<BreakDown> iterator = questions.iterator(); iterator.hasNext(); ) {
            BreakDown breakDown = iterator.next();
            if (breakDown.getParts().isEmpty()) {
                break;
            }
            System.out.print("\nCzy awaria dotyczy: " +
                    breakDown.getDescription() +
                    "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

            if (sc.next().equals("y")) {
                return breakDown.getParts();
            } else if (iterator.hasNext()) {
                System.out.println("\nNastępna opcja: ");
            }
        }
        if (breakDownIsNotDetected) {
            System.out.println("\nCzęść nie znaleziona \n");
        }
        textMenu.options();
        return null;
    }

    //  list of recomended parts' to repair <Parts>
    protected void giveParts(List<Parts> question) {
        System.out.println("\nLista proponowanych części: ");

        for (int i = 0; i < question.size(); i++) {
            // System.out.println("- " + question.get(i).getPart());
            lista.add(question.get(i).getPart());
        }
        logger.info("Stop Function");
    }

    // convert InputStream to String
    protected String getStringFromInputStream(InputStream is) {

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
            logger.error("File not found!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("File not found!");
                }
            }
        }
        return sb.toString();
    }
    public List<String> getLista() {
        return lista;
    }

    public void clearList() {
        lista.clear();
    }
}
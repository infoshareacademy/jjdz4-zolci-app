package pl.isa.autoparts.questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.TextMenu;

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
    private List<String> lista = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(Functions.class.getName());
    TextMenu textMenu = new TextMenu();

    protected List<Question> giveQuestionGrup(List<QuestionGroup> questions) throws IOException {
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
            } else if (iterator.hasNext())
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

    protected void giveParts(List<Parts> question) {
        System.out.println("\nLista proponowanych części: ");

        for (Iterator<Parts> iterator = question.iterator(); iterator.hasNext(); ) {
            Parts parts = iterator.next();
            System.out.println("- " + parts.getPart());
            lista.add(parts.getPart());
        }
    }


    // convert InputStream to String
    protected String getStringFromInputStream(InputStream is) throws IOException {

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
            logger.error("IOException: File not found! \"questions.xml\"");
            textMenu.options();
        } catch (NullPointerException e) {
            logger.error("NullPointerException - while mapping \"questions.xm");
            textMenu.options();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("IOException: File not found! \"questions.xml\"");
                    textMenu.options();
                }
            }
        }
        return sb.toString();
    }
    public List<String> getLista() {
        return lista;
    }
}

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
import java.util.List;
import java.util.Scanner;

public class Functions {
    private Scanner sc = new Scanner(System.in);
//    Logger logger = LoggerFactory.getLogger(Functions.class.getName());

//    public Functions(){
//        logger.info("");
//    }

    private List<String> lista = new ArrayList<>();

    TreeOperations treeOperations = new TreeOperations();
    TextMenu textMenu = new TextMenu();

    //    questions about parts of car, <QuestionGroup>
    protected void giveQuestionGrup(List<QuestionGroup> question, boolean flag) throws IOException {
//        logger.info("Start Function");

        for (int i = 0; i < question.size(); i++) {
            if (!question.get(i).getQuestions().isEmpty() && flag) {

                System.out.print("Czy awaria dotyczy: " +
                        question.get(i).getName() +
                        "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveQuestion(question.get(i).getQuestions(), true);
                    break;
                }
            }
            if (i < question.size() - 1)
                System.out.println("\nNastępna opcja: \n");
        }
        System.out.println("\nNie wybrałeś żadnej kategorii!\n\n\n");
        textMenu.options(treeOperations);
    }

    //  questions about more specific parts of car, <Question>
    private void giveQuestion(List<Question> question, boolean flag) throws IOException {

        for (int i = 0; i < question.size(); i++) {
            if (!question.get(i).getBreakDown().isEmpty() && flag) {

                System.out.print("\nCzy awaria dotyczy: " +
                        question.get(i).getDescripton() +
                        "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveBreakDown(question.get(i).getBreakDown(), true);
                    break;
                }
            }
            if (i < question.size() - 1)
                System.out.println("\nNastępna opcja: ");
        }
        System.out.println("\nNie wybrałeś żadnej kategorii!\n\n\n");
        textMenu.options(treeOperations);
    }

    //  questions about specific faults of car's parts <BreakDown>
    private void giveBreakDown(List<BreakDown> question, boolean flag) throws IOException {

        for (int i = 0; i < question.size(); i++) {
            if (!question.get(i).getParts().isEmpty() && flag) {

                System.out.print("\nCzy awaria dotyczy: " +
                        question.get(i).getDescription() +
                        "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveParts(question.get(i).getParts());
                    break;
                }
            }
            if (i < question.size() - 1)
                System.out.println("\nCzęść nie znaleziona ");
        }
        System.out.println("\n");
        textMenu.options(treeOperations);
    }

    //  list of recomended parts' to repair <Parts>
    private void giveParts(List<Parts> question) {
        System.out.println("\nLista proponowanych części: ");

        for (int i = 0; i < question.size(); i++) {
            System.out.println("- " + question.get(i).getPart());
            lista.add(question.get(i).getPart());
        }
//        logger.info("Stop Function");
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
//            logger.error("File not found!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
//                    logger.error("File not found!");
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

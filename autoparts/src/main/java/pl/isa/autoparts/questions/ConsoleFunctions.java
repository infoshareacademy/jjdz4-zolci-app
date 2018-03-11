package pl.isa.autoparts.questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.TextMenu;

import java.io.IOException;
import java.util.*;

public class ConsoleFunctions {
    private Scanner scanner = new Scanner(System.in);
    private Logger logger = LoggerFactory.getLogger(ConsoleFunctions.class.getName());

    private List<String> partsList = new ArrayList<>();
    private TextMenu textMenu = new TextMenu();

    protected List<Question> chooseQuestionGroup(List<QuestionGroup> questions) throws IOException {
        logger.debug("Start Function");

        for (Iterator<QuestionGroup> iterator = questions.iterator(); iterator.hasNext(); ) {
            QuestionGroup questionGroup = iterator.next();
            if (questionGroup.getQuestions().isEmpty()) {
                break;
            }
            System.out.print("Czy awaria dotyczy: " +
                    questionGroup.getName() +
                    "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

            if (scanner.next().equals("y")) {
                return questionGroup.getQuestions();
            } else if (iterator.hasNext()) {
                System.out.println("\nNastępna opcja: \n");
            }
        }
        System.out.println("\nNie wybrałeś żadnej kategorii!\n\n\n");
        textMenu.options();
        return null;
    }

    protected List<BreakDown> chooseQuestion(List<Question> questions) throws IOException {

        for (Iterator<Question> iterator = questions.iterator(); iterator.hasNext(); ) {
            Question question = iterator.next();
            if (question.getBreakDown().isEmpty()) {
                break;
            }
            System.out.print("\nCzy awaria dotyczy: " +
                    question.getDescripton() +
                    "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

            if (scanner.next().equals("y")) {
                return question.getBreakDown();
            } else if (iterator.hasNext())
                System.out.println("\nNastępna opcja: ");
        }
        System.out.println("\nNie wybrałeś żadnej kategorii!\n\n\n");
        textMenu.options();
        return null;
    }

    protected List<Parts> chooseBreakDown(List<BreakDown> questions) throws IOException {

        for (Iterator<BreakDown> iterator = questions.iterator(); iterator.hasNext(); ) {
            BreakDown breakDown = iterator.next();
            if (breakDown.getParts().isEmpty()) {
                break;
            }
            System.out.print("\nCzy awaria dotyczy: " +
                    breakDown.getDescription() +
                    "?\nwcisnij ('y'=Yes/'n'=No) jesli potwierdzasz: ");

            if (scanner.next().equals("y")) {
                return breakDown.getParts();
            } else if (iterator.hasNext()) {
                System.out.println("\nNastępna opcja: ");
            }
        }
        System.out.println("\nCzęść nie znaleziona \n");
        textMenu.options();
        return null;
    }

    protected void chooseParts(List<Parts> question) {
        System.out.println("\nLista proponowanych części: ");

        for (int i = 0; i < question.size(); i++) {
            partsList.add(question.get(i).getPart());
        }
        logger.debug("Stop Function");
    }

    public List<String> getPartsList() {
        return partsList;
    }
}
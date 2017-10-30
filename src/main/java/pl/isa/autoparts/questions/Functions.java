package pl.isa.autoparts.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Functions {
    private Scanner sc = new Scanner(System.in);


//    questions about parts of car, <QuestionGroup>
protected void giveQuestionGrup(List<QuestionGroup> q1, boolean flag) {

        for (int i = 0; i < q1.size(); i++) {
            if (!q1.get(i).getQuestions().isEmpty() && flag) {

                System.out.print("Czy awaria dotyczy: " +
                        q1.get(i).getName() +
                        "?\nwcisnij ('y=Yes'/'n'=No) jesli potwiedzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveQuestion(q1.get(i).getQuestions(), true);
                    break;
                }
            }
                System.out.println("\nCzęść nie znaleziona\n");
        }
    }

//  questions about more specific parts of car, <Question>
    private void giveQuestion(List<Question> q1, boolean flag) {

        for (int i = 0; i < q1.size(); i++) {
            if (!q1.get(i).getBreakDown().isEmpty() && flag) {

                System.out.print("\nCzy awaria dotyczy: " +
                        q1.get(i).getDescripton() +
                        "?\nwcisnij ('y=Yes'/'n'=No) jesli potwiedzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveBreakDown(q1.get(i).getBreakDown(), true);
                    break;
                }
            }
                System.out.println("\nCzęść nie znaleziona");
        }
    }

//  questions about specific faults of car's parts <BreakDown>
    private void giveBreakDown(List<BreakDown> q1, boolean flag) {

        for (int i = 0; i < q1.size(); i++) {
            if (!q1.get(i).getParts().isEmpty() && flag) {

                System.out.print("\nCzy awaria dotyczy: " +
                        q1.get(i).getDescription() +
                        "?\nwcisnij ('y=Yes'/'n'=No) jesli potwiedzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveParts(q1.get(i).getParts());
                    break;
                }
            }
                System.out.println("\nCzęść nie znaleziona");
        }
    }

//  list of recomended parts' to repair <Parts>
    private void giveParts(List<Parts> q1) {
        System.out.println("\nLista proponowanych części: ");

        for (int i = 0; i < q1.size(); i++) {
            System.out.println("- " + q1.get(i).getPart());
        }
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

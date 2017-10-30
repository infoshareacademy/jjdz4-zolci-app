package pl.isa.autoparts.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Functions {

    protected void giveQuestionGrup(TopClass topClass) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        for (int i = 0; i < topClass.getGrupaPytan().size(); i++) {

            if (!topClass.getGrupaPytan().get(i).getQuestions().isEmpty() && flag) {
                System.out.print("Czy awaria dotyczy części: " +
                        topClass.getGrupaPytan().get(i).getName() +
                        "\nwcisnij 'y' jesli potwiedzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveQuestion(topClass.getGrupaPytan().get(i).getQuestions());
                }
            }
        }
    }

    private void giveQuestion(List<Question> q1) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < q1.size(); i++) {
            if (!q1.get(i).getBreakDown().isEmpty() && flag) {
                System.out.print("\nCzy awaria dotyczy: " +
                        q1.get(i).getDescripton() +
                        "\nwcisnij 'y' jesli potwiedzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveBreakDown(q1.get(i).getBreakDown());
                }
            }
        }
    }

    private void giveBreakDown(List<BreakDown> q1) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < q1.size(); i++) {
            if (!q1.get(i).getParts().isEmpty() && flag) {
                System.out.print("\nCzy awaria dotyczy: " +
                        q1.get(i).getDescription() +
                        "\nwciśnij 'y' jesli potwierdzasz: ");

                if (sc.next().equals("y")) {
                    flag = false;
                    giveParts(q1.get(i).getParts());
                }
            }
        }
    }

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

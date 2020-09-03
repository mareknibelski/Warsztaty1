package gra_w_zgadywanie_liczb_2;

import java.util.Scanner;

public class gra {

    static int min = 0;
    static int max = 1000;
    static int guess = (int) ((max - min) / 2) + min;

    static Scanner scan = new Scanner(System.in);

    static int i = 0;

    static String result = "";

    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max. 10 próbach");

        System.out.println("Zgaduję " + guess);
        System.out.println("Próba 1");

        System.out.println("Pobierz odpowiedź z zestawu:");
        System.out.println("- za dużo,");
        System.out.println("- za mało,");
        System.out.println("- zgadłeś.");

        result = scan.nextLine();

        for (i = 0; i < 9; i ++) {

            if (result.equals("zgadłeś")) {
                System.out.println("Wygrałeś");
                break;
            } else if (result.equals("za dużo")) {
                max = guess;

                sequence();
            } else if (result.equals("za mało")) {
                min = guess;

                sequence();
            } else {
                System.out.println("Nie oszukuj!!!");
            }
        }
    }

    private static void sequence() {

        guess = ((max - min) / 2) + min;

        System.out.println("Zgaduję " + guess);
        System.out.println("Próba " + (i + 2));

        System.out.println("Pobierz odpowiedź z zestawu:");
        System.out.println("- za dużo,");
        System.out.println("- za mało,");
        System.out.println("- zgadłeś.");

        result = scan.nextLine();

    }
}

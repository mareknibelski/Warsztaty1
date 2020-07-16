package gra_w_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class gra {

    public static Scanner scan = new Scanner(System.in);;

    public static void main(String[] args) {

        Random r = new Random();
        int num = r.nextInt(102) + 1;

//      Punkt 1
        System.out.println("Zganij liczbę");

//      Punkt 2
        notNumber();
        int number = scan.nextInt();

        while (number != num) {    // Punkt 5
            if (number < num) {    // Punkt 3
                System.out.println("Za mało");
                notNumber();
                number = scan.nextInt();
            } else if (number > num) {    // Punkt 4
                System.out.println("Za dużo");
                notNumber();
                number = scan.nextInt();
            }
        }

        System.out.println("Zgadłeś!");
    }

//  Sprawdzanie czy liczba jest liczbą
    public static void notNumber() {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("To nie jest liczba");
        }
    }

}

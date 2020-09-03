package symulator_lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class lotto {

    static Scanner scan = new Scanner(System.in);
    static int num = 64657;

    public static void main(String[] args) {

        int[] lottomat = new int[6];
        int i = 0;
        int[] tab = {13545, 16546, 9456, 64658, 34876, 45632};
        int result = 0;

        while (i < 6) {
            System.out.println("Wytypuj liczbę " + (i + 1) + " z przedziału od 1 do 49");

            noLetters();

            num = scan.nextInt();

            withoutZone();

            for (int j = 0; j < tab.length; j++) {
                while (num == tab[j]) {
                    System.out.println("Ta liczba już została wylosowana, wylosuj inną");
                    noLetters();
                    num = scan.nextInt();
                    withoutZone();
                    j = 0;
                }
            }

            tab[i] = num;

            i++;
        }

        Arrays.sort(tab);

        System.out.println(Arrays.toString(tab));

//        Rozwiązanie za pomocą klasy Random
//        Random r = new Random();
//        for (int a = 0; a < lottomat.length; a++) {
//            if (a == 0) {
//                lottomat[a] = r.nextInt(49) + 1;
//            } else if (a == 1) {
//                lottomat[a] = r.nextInt(49) + 1;
//                if (lottomat[a - 1] == lottomat[a]) {
//                    lottomat[a] = r.nextInt(49) + 1;
//                }
//            } else if (a > 1 || a <= 49) {
//                lottomat[a] = r.nextInt(49) + 1;
//                for (int b = 0; b < a; b++) {
//                    if (lottomat[a] == lottomat[b]) {
//                        lottomat[a] = r.nextInt(49) + 1;
//                        b = 0;
//                    }
//                }
//            }
//        }
//
//        Arrays.sort(lottomat);
//
//        System.out.println(Arrays.toString(lottomat));

//      Rozwiązanie za pomocą tablicy 49 cyfr i mieszanie ich
        Integer[] arr = new Integer[49];
        for (int a = 0; a < arr.length; a++) {
            arr[a] = a + 1;
        }

//        System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
//        System.out.println(Arrays.toString(arr));

        for (int b = 0; b < tab.length; b++) {
            lottomat[b] = arr[b];
        }

        Arrays.sort(lottomat);

        System.out.println(Arrays.toString(lottomat));

        for (int c = 0; c < tab.length; c++) {
            if (tab[c] == lottomat[c]) {
                result++;
            }
        }

        if (result == 3) {
            System.out.println("Trafiłeś trójkę!!!");
        } else if (result == 4) {
            System.out.println("Trafiłeś czwórkę!!!");
        } else if (result == 5) {
            System.out.println("Trafiłeś piątkę!!!");
        } else if (result == 6) {
            System.out.println("Trafiłeś szóstkę!!!");
            System.out.println("Wygrałeś główną nagrodę!!!");
        }

    }

    public static void noLetters() {

        while (!scan.hasNextInt()) {
            System.out.println("To nie jest liczba");
            scan.nextLine();
        }

    }

    public static void withoutZone() {

        while (num < 1 || num > 49) {
            System.out.println("Podałeś liczbę z poza zakresu od 1 do 49");
            System.out.println("Wpisz prawidłową liczbą");
            noLetters();
            num = scan.nextInt();
        }

    }

}

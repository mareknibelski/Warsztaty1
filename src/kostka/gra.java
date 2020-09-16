package kostka;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class gra {

    static String kod = "";

    public static void main(String[] args) {

        cube(kod);

    }

    public static void cube(String kod) {

        Scanner scann = new Scanner(System.in);

        System.out.println("Podaj kod");
        kod = scann.next();

        while (!kod.contains("D3") && !kod.contains("D4") && !kod.contains("D6") && !kod.contains("D8")
                && !kod.contains("D10") && !kod.contains("D12") && !kod.contains("D20") && !kod.contains("D100")) {
            System.out.println("Wprowadź prawidłową wartość");
            kod = scann.next();
        }

        while (!kod.contains("+") && !kod.contains("-") && !kod.contains("")
                || kod.contains("*") || kod.contains("/")) {
            System.out.println("Nieprawidłowe działanie");
            kod = scann.next();
        }

        String parts[] = kod.split("D");

        int num = 0;

        try {
            num = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            num = 1;
        }

        int type = 0;
        int mod = 0;

        if (parts[1].contains("+")) {
            String[] parts2 = parts[1].split("\\+");
            type = Integer.parseInt(parts2[0]);
            mod = Integer.parseInt(parts2[1]);
        } else if (parts[1].contains("-")) {
            String[] parts2 = parts[1].split("-");
            type = Integer.parseInt(parts2[0]);
            mod = Integer.parseInt(parts2[1]);
            mod = -mod;
        } else if (parts[1].contains("")){
            type = Integer.parseInt(parts[1]);
        } else {
            System.out.println("To nieprawidłowe działanie!!!");
        }

        Random r = new Random();
        if (num > 1) {
            int[] tab = new int[num];

            for (int i = 0; i < num; i++) {

                int luck = r.nextInt(type) + 1;

                if (mod != 0) {
                    System.out.println(luck);
                    int numLuckMod = luck + mod;
                    System.out.println("rzucono: " + numLuckMod);
                    tab[i] = numLuckMod;
                } else {
                    System.out.println("rzucono: " + luck);
                    tab[i] = luck;
                }
            }

            System.out.println("rzucono" + Arrays.toString(tab));
        } else {

            int luck = r.nextInt(type) + 1;

            if (mod != 0) {
                System.out.println(luck);
                int luckMod = luck + mod;
                System.out.println("rzucono: " + luckMod);
            } else {
                System.out.println("rzucono: " + luck);
            }
        }
    }
}
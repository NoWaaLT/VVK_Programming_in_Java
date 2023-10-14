import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        int counter = 0;
        boolean difference = false;
        String correctness;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Bilieto numerio patikra

        while (true) {
            System.out.println("Iveskite bilieto numerį: ");
            correctness = sc.next();

            boolean onlyNumbers = correctness.matches("[0-9]+");

            if (onlyNumbers) {
                if (correctness.length() == 6) {
                    break;
                } else {
                    System.out.println("Bilieto numeris turi susidaryti iš šešių skaičių!");
                }
            } else {
                System.out.println("Įvesčiai naudokite tik skaičius");
            }
        }

        int[] dissolvedNumber = new int[correctness.length()];

        for (int i = 0; i < correctness.length(); i++) {
            dissolvedNumber[i] = Character.getNumericValue(correctness.charAt(i));
        }

        loop:
        for (int i = 0; i < correctness.length(); i++) {
            for (int j = i + 1; j < correctness.length(); j++) {
                if (dissolvedNumber[i] == dissolvedNumber[j]) {
                    difference = true;
                    break loop;
                }
            }
        }

        if (!difference) {
            if (dissolvedNumber[0] + dissolvedNumber[1] + dissolvedNumber[2] ==
                dissolvedNumber[3] + dissolvedNumber[4] + dissolvedNumber[5]) {
                System.out.println("Sveikinime! Bilieto numeris yra laimingas!");
                return;
            } else {
                System.out.println("Bilietas nieko nelaimėjo. Bandykite dar kartą");
            }
        } else {
            System.out.println("Bilietas nieko nelaimėjo. Bandykite dar kartą");
        }
        System.out.println("Ar norite generuoti atsitiktinį bilieto numerį iki laimingo? Įveskite true, jeigu taip, false - jeigu ne");

        boolean trigger;

        while (true) {
            correctness = sc.next();
            if (correctness.equalsIgnoreCase("true")) {
                trigger = true;
                break;
            } else if (correctness.equalsIgnoreCase("false")) {
                trigger = false;
                break;
            } else {
                System.out.println("Įvestas žodis turi būti true arba false");
            }
        }

        // Atsitiktinio laimingo bilieto numerio generavimas

        if (trigger) {
            while (true) {
                difference = false;
                for (int i = 1; i < dissolvedNumber.length; i++) {
                    dissolvedNumber[i] = rand.nextInt(10);
                }
                counter++;

                loop:
                for (int i = 0; i < dissolvedNumber.length; i++) {
                    for (int j = i + 1; j < dissolvedNumber.length; j++) {
                        if (dissolvedNumber[i] == dissolvedNumber[j]) {
                            difference = true;
                            break loop;
                        }
                    }
                }

                if (!difference) {
                    if (dissolvedNumber[0] + dissolvedNumber[1] + dissolvedNumber[2] ==
                        dissolvedNumber[3] + dissolvedNumber[4] + dissolvedNumber[5]) {
                        System.out.println("Atsitikintai generuojant laimingą bilieto numerį prireikės kartų: " + counter);
                        System.out.println("Laimingas numeris yra ");
                        for (int number : dissolvedNumber) {
                            System.out.print(number);
                        }
                        return;
                    }
                }
            }
        }
    }
}

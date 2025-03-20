package miscellaneous;

import java.util.Scanner;

//?Sample Input:
//        S;M;plasticCup()
//        C;V;mobile phone
//        C;C;coffee machine
//        S;C;LargeSoftwareBook
//        C;M;white sheet of paper
//        S;V;pictureFrame

//?Sample Output:
//        plastic cup
//        mobilePhone
//        CoffeeMachine
//        large software book
//        whiteSheetOfPaper()
//        picture frame


public class CamelCaseConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) { //? rods input one by one
            String input = sc.nextLine();
            String[] parts = input.split(";");

            String operation = parts[0];
            String type = parts[1];
            String words = parts[2];

            if (operation.equals("S")) {
                // Split operation
                if (type.equals("M")) {
                    words = words.substring(0, words.length() - 2); // Remove '()' for method
                }
                splitCamelCase(words);
            } else if (operation.equals("C")) {
                // Combine operation
                combineCamelCase(type, words);
            }
        }

        sc.close();
    }

    private static void splitCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(" ").append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        System.out.println(result.toString().trim());
    }

    private static void combineCamelCase(String type, String words) {
        String[] wordArray = words.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordArray.length; i++) {
            String word = wordArray[i];
            if (i == 0 && (type.equals("V") || type.equals("M"))) {
                result.append(word.toLowerCase());
            } else {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase());
            }
        }

        if (type.equals("M")) {
            result.append("()");
        }

        System.out.println(result.toString());
    }
}

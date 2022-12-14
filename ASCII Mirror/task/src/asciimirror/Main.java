package asciimirror;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void fileFinder(String path) {
        File file = new File(path);
        List<String> copy = new ArrayList<>();
        try (Scanner scanFile = new Scanner(file)) {
            while (scanFile.hasNext()) {
                copy.add(scanFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        int maxString = 0;
        for(String stringSize : copy) {
            if (stringSize.length() > maxString) {
                maxString = stringSize.length();
            }
        }


        for (String line : copy) {
            String whitespace = "";
            int amountWhitespace = maxString - line.length();
            for (int i = 0; i < amountWhitespace; i++) {
                whitespace += " ";
            }
            String strgReverseSigns = reverseSign(line);
            StringBuilder originalReverseSigns = new StringBuilder(strgReverseSigns);
            StringBuilder reverse = originalReverseSigns.reverse();
            System.out.println(line + whitespace + " | " + whitespace + reverse);

        }
    }

    public static String reverseSign(String oldString) {
        String newString = "";
        for (int i = 0; i < oldString.length(); i++) {

            switch (oldString.charAt(i)) {
                case '<' :
                    newString += '>';
                    break;
                case '>':
                    newString += '<';
                    break;
                case '[':
                    newString += ']';
                    break;
                case ']':
                    newString += '[';
                    break;

                case '{':
                    newString += '}';
                    break;
                case '}':
                    newString += '{';
                    break;
                case '(':
                    newString += ')';
                    break;
                case ')':
                    newString += '(';
                    break;
                case '/':
                    newString += '\\';
                    break;
                case '\\':
                    newString += '/';
                    break;
                default:
                    newString += oldString.charAt(i);
            }
        }
        return newString;
    }



    public static void main(String[] args) {
        System.out.println("file path");
        Scanner input = new Scanner(System.in);
        String searchString = input.nextLine();
        fileFinder(searchString);
    }
}


import java.util.Scanner;

public class PalindromeCheckerApp {

    /*
    UC3
    @author Developer
    @version 1.0
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a word to check if it is a palindrome: ");
        String word = scanner.nextLine();

        // Reverse string using loop and concatenation
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i); // string concatenation
        }

        // Compare original and reversed using equals()
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        scanner.close();
    }
}

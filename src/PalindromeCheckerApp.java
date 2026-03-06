public class PalindromeCheckerApp {

    /*
    UC7: Deque-Based Optimized Palindrome Checker
    @author saisuryapati
    @version 7.0
    */

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 7.0");
        System.out.println("System initialized successfully");

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (checkPalindrome(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        scanner.close();
    }

    // UC7 Logic using Deque
    public static boolean checkPalindrome(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        java.util.Deque<Character> deque = new java.util.LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        // Compare front and rear
        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }
}
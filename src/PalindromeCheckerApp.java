import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 13.0");
        System.out.println("Performance Comparison Module");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        /* Stack Strategy Performance */
        long startStack = System.nanoTime();
        boolean stackResult = checkUsingStack(normalized);
        long endStack = System.nanoTime();

        /* Deque Strategy Performance */
        long startDeque = System.nanoTime();
        boolean dequeResult = checkUsingDeque(normalized);
        long endDeque = System.nanoTime();

        System.out.println("\nStack Strategy Result: " + stackResult);
        System.out.println("Stack Execution Time: " + (endStack - startStack) + " ns");

        System.out.println("\nDeque Strategy Result: " + dequeResult);
        System.out.println("Deque Execution Time: " + (endDeque - startDeque) + " ns");

        scanner.close();
    }

    /* Stack Palindrome Algorithm */
    public static boolean checkUsingStack(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    /* Deque Palindrome Algorithm */
    public static boolean checkUsingDeque(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}
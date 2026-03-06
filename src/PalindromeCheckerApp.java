public class PalindromeCheckerApp {

    /*
    UC8: Linked List Based Palindrome Checker
    @author saisuryapati
    @version 8.0
    */

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 8.0");
        System.out.println("System initialized successfully");

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        scanner.close();
    }

    // UC8 Logic using Linked List
    public static boolean isPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Node head = null;
        Node tail = null;

        // Create linked list
        for (char ch : normalized.toCharArray()) {
            Node newNode = new Node(ch);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle using slow and fast pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reverse Linked List
    private static Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
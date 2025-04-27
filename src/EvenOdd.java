import java.util.*;
public class EvenOdd {

    void evenOdd(Node head) {
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        Node current = head;
        while (current != null) {
            if (current.num % 2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        // If there are no even nodes or no odd nodes
        if (evenStart == null || oddStart == null) {
            return;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;

        // Print the final list
        Node temp = evenStart;
        while (temp != null) {
            System.out.print(temp.num + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        EvenOdd obj = new EvenOdd();
        System.out.println("After arranging even and odd nodes:");
        obj.evenOdd(head);
    }
}

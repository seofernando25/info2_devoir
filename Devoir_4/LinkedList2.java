package Devoir_4;

import java.util.Objects;

public class LinkedList2 {

    private static class Node {
        int value; // value of an item in the list.
        Node next; // Pointer to the next node in the list.
    }

    static Node reverse(Node obj) {
        Node p = obj; // For traversing the list.

        if (!Objects.nonNull(obj))
            return null;

        // If list is size one
        if (!Objects.nonNull(obj.next))
            return obj;

        // Get the number of items in the list
        var count = 0;
        while (Objects.nonNull(p)) {
            p = p.next;
            count++;
        }

        // Creates an array of nodes
        var nodeArray = new Node[count];
        p = obj;
        for (int i = 0; i < count; i++) {
            nodeArray[i] = p;
            p = p.next;
        }

        // Reverse the list with help of the array
        nodeArray[0].next = null;
        for (int j = count - 1; j > 0; j--) {
            nodeArray[j].next = nodeArray[j - 1];
        }
        return nodeArray[count - 1];
    }

    static void display(Node first) {
        String str = "";
        while (true) {
            str += first.value + " "; // displays the value with a space in between
            first = first.next;
            if (!Objects.nonNull(first)) { // if the node is null
                break; // end the
            }
        }
        System.out.println(str);
    }

    static int count(Node head) {
        int count = 0;
        while (true) {
            if (head.value == 0) {  //every 0 it finds, add 1 to the count
                count++;
            }
            head = head.next;
            if (!Objects.nonNull(head))  //if head is null, return the count variable
                return count;
        }
    }

    static int countRecursive(Node head) {
        if (head.value == 0) { // if the value is 0
            if (Objects.nonNull(head.next))
                return 1 + countRecursive(head.next); // add one and recall the function
            return 1;
        }
        if (Objects.nonNull(head.next)) // if the value isn't 0
            return countRecursive(head.next); // recall the next function
        return 0;
    }

    public static void main(String[] args) {

        Node list = null; // A list, initially empty.
        Node reverseList; // The reversed list.

        int count = 0; // The number of elements in the list

        while (true) {
            // add a new node onto the head of the list before repeating.
            count++;
            if (count == 10)
                break;
            Node head = new Node(); // A new node to add to the list.
            head.value = (int) (Math.random() * 5); // A random value.
            head.next = list;
            list = head;
        }

        // Print the current list ; its reverse and the number of zeros in the list
        // using both methods
        System.out.print("The list: ");
        display(list);
        System.out.println();
        list = reverse(list);
        System.out.print("The reversed list: ");
        display(list);
        System.out.println();
        System.out.println();
        System.out.print("The number of zeros in the list : ");
        System.out.println(count(list));
        System.out.print("The number of zeros in the list, using recursion : ");
        System.out.println(countRecursive(list));

    }

}
package Devoir_4;

import java.util.Objects;

public class LinkedList1 {

    private static class Node {
        String value;
        Node next;
    }

    private Node head;

    public boolean find(String obj) {
        Node p;
        p = head;
        if (!Objects.nonNull(p)) {
            return false;
        }

        if (p.value == obj) {
            return true;
        }

        while (Objects.nonNull(p.next)) {
            p = p.next;
            if (p.value == obj) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String obj) {
        if (head == null) {
            return false;
        } else if (head.value.equals(obj)) {
            if (Objects.nonNull(head.next)) {
                head = head.next;
            } else {
                head = null;
            }

        } else {
            // Check other elements
            Node current = head;
            Node next;

            while (Objects.nonNull(current.next)) {
                next = current.next;

                // check if next value is the one we want to delete
                if (next.value.equals(obj)) {
                    // check if the next next value exists
                    if (Objects.nonNull(current.next.next)) {
                        // next next exists set current value to next next
                        current.next = current.next.next;
                    } else { // if it doesn't exist
                        current.next = null;
                    }
                    return true;
                }
                current = current.next;
            }

            return false;
        }

    }

    public void add(String obj) {
        Node newNode;
        newNode = new Node();
        newNode.value = obj;

        if (head == null) {
            head = newNode;
        } else if (head.value.compareTo(obj) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            // Check other elements
            Node current = head;
            Node next;

            while (Objects.nonNull(current.next)) {
                next = current.next;
                // Iterates all elements
                // current -> next -> ...

                // check if next value is the place we want to add it
                if (next.value.compareTo(obj) >= 0) {
                    // check if the next next value exists
                    // next next exists set current value to next next
                    newNode.next = current.next;
                    current.next = newNode;
                }
                // Iterates all elements
                current = current.next;
            }
            current.next = newNode; // if it's bigger than all the current nodes, add it at the end

        }

    }

    public String[] getList() {
        int count;
        Node p;
        String[] elements;
        count = 0;
        p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        elements = new String[count];
        count = 0;
        p = head;
        for (int i = 0; i < count; i++) {
            elements[i] = p.value;
            p = p.next;
        }
        return elements;
    }

    public String toString() {
        String str = "";
        var p = this.head;
        while (p != null) {
            str += "('" + p.value + "') -> ";
            p = p.next;
        }
        return str;
    }
}
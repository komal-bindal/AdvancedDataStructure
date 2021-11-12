package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Insert an element at the beginning of linked list
     *
     * @param data to be inserted
     */
    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            temp.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.previous;
        }
        System.out.println("null");
    }

    private class ListNode {
        private final int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data) {
            this.previous = null;
            this.data = data;
            this.next = null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.insertLast(4);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();
        doublyLinkedList.deleteFirst();
        doublyLinkedList.displayForward();
        doublyLinkedList.deleteLast();
        doublyLinkedList.displayForward();
    }
}

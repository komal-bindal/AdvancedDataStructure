package LinkedList;

import java.util.List;
import java.util.NoSuchElementException;

public class CircularLinkedList {
    private int length;
    private ListNode last;

    public CircularLinkedList() {
        this.last = null;
        this.length = 0;
    }


    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }


    public ListNode deleteFirstt() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = last;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = last;
        if (last.next == last) {
            last = null;
        } else {
            ListNode currentNode = last.next;
            while (currentNode.next != last) {
                currentNode = currentNode.next;
            }
            currentNode.next = last.next;
            last = currentNode;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        this.last = fourth;

    }

    public void display() {
        if (last == null) {
            return;
        }
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " -> ");
            first = first.next;
        }
        System.out.println(first.data + " ");
    }

    private class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertFirst(5);
        cll.insertFirst(6);
        cll.insertFirst(7);
        cll.insertLast(8);
        cll.insertLast(9);
        cll.display();
        cll.deleteLast();
        cll.display();
    }
}

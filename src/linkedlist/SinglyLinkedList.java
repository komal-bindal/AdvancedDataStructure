package linkedlist;

public class SinglyLinkedList {
    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertLast(2);
        singlyLinkedList.insertLast(3);
        singlyLinkedList.insertLast(4);
        singlyLinkedList.insertLast(5);
        singlyLinkedList.insertLast(6);
        singlyLinkedList.display();
        System.out.println();
        System.out.println("Size = " + singlyLinkedList.getSize());
        singlyLinkedList.insertFirst(500);
        singlyLinkedList.display();
        System.out.println();
        singlyLinkedList.insertLast(100);
        singlyLinkedList.display();
        System.out.println();
        System.out.println(singlyLinkedList.removeFirst().data);
        singlyLinkedList.display();
        System.out.println(singlyLinkedList.findMiddle().data);

    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value of n" + n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + "is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public ListNode removeDuplicatesInSortedList() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode insertInSortedList(int n) {
        ListNode current = head;
        ListNode newNode = new ListNode(n);
        ListNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public ListNode insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public ListNode insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return current;
    }

    public ListNode removeFirst() {
        if (head == null) {
            return null;
        }
        ListNode deletedNode = head;
        head = head.next;
        deletedNode.next = null;
        return deletedNode;
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public void insertAtPosition(int val, int pos) {
        ListNode newNode = new ListNode(val);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        }
        ListNode prev = head;
        int count = 1;
        while (count < pos - 1) {
            prev = prev.next;
            count++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public void deleteAtPosition(int pos) {
        if (pos == 1) {
            head = head.next;
        }
        ListNode prev = head;
        int count = 1;
        while (count < pos - 1) {
            prev = prev.next;
            count++;
        }
        prev.next = prev.next.next;
    }

    public ListNode findMiddle() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    private static class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

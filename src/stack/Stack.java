package stack;

import java.util.NoSuchElementException;

public class Stack {
    private ListNode top;
    private int length;

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.data;

    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = top;
        top = top.next;
        temp.next = null;
        length--;
        return temp.data;

    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
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

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}

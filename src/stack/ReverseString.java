package stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("ABCDE"));
    }

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}

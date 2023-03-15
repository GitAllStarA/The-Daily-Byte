/*
* Validate Characters
Stacks & Queues
Easy
This question is asked by Google. Given a string only containing the following characters (, ), {, }, [, and ]
* return whether or not the opening and closing characters are in a valid order.

Ex: Given the following strings...

"(){}[]", return true
"(({[]}))", return true
"{(})", return false
*
* */

package StacksNQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidCharacters {

    public static void main(String[] args) {
        String s = "(({[]}))";
        String s2 = "({})";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
            } else if (!stack.empty() && stack.peek() == '(' && x == ')' ) {
                stack.pop();
            } else if (!stack.empty()  && stack.peek() == '[' && x == ']') {
                stack.pop();
            } else if (!stack.empty() && stack.peek() == '{' && x == '}' ) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        System.out.println(stack);
        return stack.empty();
    }
}


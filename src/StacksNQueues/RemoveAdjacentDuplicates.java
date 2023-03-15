/*
* Remove Adjacent Duplicates
Stacks & Queues
Easy
This question is asked by Facebook. Given a string s containing only lowercase letters, continuously remove adjacent characters that are the same and return the result.

Ex: Given the following strings...

s = "abccba", return ""
s = "foobar", return "fbar"
s = "abccbefggfe", return "a"

*
* */


package StacksNQueues;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(remainingString(s));
    }

    public static String remainingString(String s) {
        if (s.length()==0)
            return "";

        Stack<Character> stack = new Stack<>();
        for (char x:s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == x ){
                stack.pop();
            }
            else {
                stack.push(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char x : stack){
            sb.append(x);
        }
        return sb.toString();
    }
}

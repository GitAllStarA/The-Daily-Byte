/*
* Compare Keystrokes
Stacks & Queues
Easy
This question is asked by Amazon. Given two strings s and t, which represents a sequence of keystrokes,
where # denotes a backspace, return whether or not the sequences produce the same result.

Ex: Given the following strings...

s = "ABC#", t = "CD##AB", return true
s = "como#pur#ter", t = "computer", return true
s = "cof#dim#ng", t = "code", return false

*
*
* */


package StacksNQueues;

import java.util.Stack;

public class CompareKeyStrokes {

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(areSame(s, t));
    }

    public static boolean areSame(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();


        for (char x : s.toCharArray()) {
            if (x == '#' && !s1.isEmpty() && s1.peek() != '#') {
                s1.pop();
            }
            if (x=='#'){
                continue;
            }
            else {
                s1.push(x);
            }
        }

        for (char x : t.toCharArray()) {
            if (x == '#' && !s2.isEmpty() && s2.peek() != '#') {
                s2.pop();
            }
            if (x=='#'){
                continue;
            }
            else {
                s2.push(x);
            }
        }
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }

}


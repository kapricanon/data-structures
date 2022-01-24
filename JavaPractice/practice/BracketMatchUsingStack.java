package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BracketMatchUsingStack {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(matchBracket("{[()]}"));    }

    private static boolean matchBracket(String expr) {

        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < expr.length(); i++) {

            char character = expr.charAt(i);

            if(character == '{' || character == '[' || character == '(') {
                stack.addElement(String.valueOf(character));
            } else {
                String temp = stack.pop();
                switch (temp) {
                    case "{" :
                        if(character != '}') return false;
                        break;
                    case "[":
                        if(character != ']') return false;
                        break;
                    case "(":
                        if(character != ')') return false;
                        break;
                }

            }
        }
        return stack.isEmpty();
    }
}
package Homework.Stack;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidThree("({[(()]}))"));
        System.out.println(isValidThree("))]])"));
        System.out.println(isValidThree("(({{{]]]}}(((("));
        System.out.println(isValidThree("{{{)))"));
        System.out.println(isValidThree("{})([]"));

    }

    public static boolean isValidThree(String sequence) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (char c : sequence.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

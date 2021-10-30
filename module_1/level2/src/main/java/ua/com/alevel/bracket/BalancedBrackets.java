package ua.com.alevel.bracket;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class BalancedBrackets {

    public static boolean isBracketBalanced(String expression) {
        if (expression == null) return false;
        if (expression.isBlank()) return true;
        String allBrackets = getWithoutSpaceBrackets(expression);
        if (allBrackets.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < allBrackets.length(); i++) {
            char x = allBrackets.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty()) return false;
            char check;

            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    private static String getWithoutSpaceBrackets(String exp) {
        String[] bracketsWithSpace = exp.split("[^({\\[)}\\]]");
        return Arrays.stream(bracketsWithSpace).distinct().collect(Collectors.joining());
    }
}

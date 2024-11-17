package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    /*
    Idea: using a stack
        looping through each character of the string
            + case 1: if char is space, just ignore
            + case 2: if digit, try to collect all the consecutive digit to make it a completely number (9, 999, 9999)
            + case 3: if sign of (+, -), update the result with the current number and the sign before it
            + case 4: if (, we need to start a new calculation within every (, so all the result before ( need to be memorized by adding to the stack) as well as the sign before the (
            + case 5: if ), we have to calculate the result with the current number and sign, get the result before ( from the stack also to update the total result.
                        after updated, remove the result from the stack
    * */
    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0, cur = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) continue;

            if (Character.isDigit(c)) {
                cur = cur * 10 + (int) c - '0';
            }

            if (c == '+' || c == '-') {
                res += cur * sign;

                sign = c == '+' ? 1 : -1;
                cur = 0;
            }

            if (c == '(') {
                stack.addLast(res);
                stack.addLast(sign);

                sign = 1;
                res = 0;
            }

            if (c == ')') {
                res += cur * sign;

                res *= stack.removeLast();
                res += stack.removeLast();

                cur = 0;
            }
        }

        return res + sign*cur;
    }
}

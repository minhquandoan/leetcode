package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public static boolean isValid(String s) {
        char[] input = s.toCharArray();
        Map<Character, Character> charMap = new HashMap<>(Map.ofEntries(
                Map.entry('}', '{'),
                Map.entry(']', '['),
                Map.entry(')', '(')
        ));

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : input) {
            if (charMap.containsKey(c)) {
                if (stack.pollLast() != charMap.get(c)) {
                    return false;
                }
                continue;
            }
            stack.addLast(c);
        }

        return stack.isEmpty();
    }
}

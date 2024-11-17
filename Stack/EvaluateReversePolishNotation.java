package Stack;

import java.util.ArrayList;
import java.util.List;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        List<Integer> resultStack = new ArrayList<>();
        resultStack.addLast(0);

        for (String t : tokens) {
            int number;
            if ((number = format(t)) != -201) {
                resultStack.addLast(number);
                continue;
            }

            int currentTop = resultStack.removeLast();
            switch (t) {
                // each operator, we will calculate the last 2 element in the stack
                case "+" :
                    currentTop += resultStack.getLast();
                    break;
                case "-" :
                    currentTop = resultStack.getLast() - currentTop;
                    break;
                case "*":
                    currentTop *= resultStack.getLast();
                    break;
                case "/":
                    currentTop = resultStack.getLast() / currentTop;
                    break;

            }

            resultStack.set(resultStack.size() - 1, currentTop);
        }
        return resultStack.getLast();
    }

    public int format(String s) {
        int number = -201;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return -201;
        }
        return number;
    }
}

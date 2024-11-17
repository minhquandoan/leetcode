package Stack;

import java.util.Stack;

public class ScoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        /* Approaching 1: using stack
        * TC: O(N)
        * SC: O(N)
        *
        * Init a stack to track the score
        * try to find the childest () (the parentheses without any nested one inside)
        * for each (, we add 0 to the stack, because when start the new (, we also have count the pair inside
        * for ex, (()(())), at index 1 we have the childest (), but at the index 3, we have another group of parentheses, so have to count again at 0, to have the second rule 2*n
        *          when adding ( at index 3, the top of stack is 0
        * we wont update the stack when meet the ), if the score is 0, that means you are reaching the childest (), compare it with 2 * score to take the 1 score,
        * if the score is above 1, then when compare 2 * score we will take 2 * score obviously
        *
        * */
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(score);
                score = 0; // when push the new score, init to 0 if there is new ( coming in
            }
            else {
                score = st.pop() + Math.max(2 * score, 1); // update the score, then in new loop, push the current core on the top of the stack
            }
        }
        return score;
    }

    public static int scoreOfParentheses2(String s) {
        int score = 0, depth = 0;
        for (int i = 0; i < s.length(); i++)
        {
            depth += (s.charAt(i) == '(') ? 1 : -1;

            if (s.charAt(i) == ')' && s.charAt(i-1) == '(')
                score += (int) Math.pow(2.0, depth);
        }
        return score;
    }
}

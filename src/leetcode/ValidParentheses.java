package leetcode;
// https://leetcode.com/problems/valid-parentheses/description/

// "" -> true
// "()" -> true
// "()" -> true
// "[]" -> true
// "()[]{}" -> true
// "([]{})" -> true
// "([{}])" -> true
// "()[{}]" -> true
// "(" -> false
// "}" -> false
// "()[{}" -> false

//1. Накапливать в ArrayList значения, удаляя при закрывании с конца. Если нет ошибок и пустой список - true

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            int len = s.length();
            if (len < 2) return false;
            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    Character peeked = stack.peek();
                    if (peeked == null) return false;
                    if (c == ']' && peeked != '[') return false;
                    if (c == ')' && peeked != '(') return false;
                    if (c == '}' && peeked != '{') return false;
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String first = "){";
        boolean result = solution.isValid(first);
        System.out.println(result);
    }
}

package q2;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (!st.empty()) {
                    if (ch == ')' && st.peek() == '(')
                        st.pop();
                    else if (ch == '}' && st.peek() == '{')
                        st.pop();
                    else if (ch == ']' && st.peek() == '[')
                        st.pop();
                    else
                        return false;
                } else {
                    return false;
                }
            }
        }
        return st.empty() ? true : false;
    }
}

public class Q2 {

}

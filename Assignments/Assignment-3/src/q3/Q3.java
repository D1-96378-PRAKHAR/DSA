package q3;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack <Character>();
        int sLen = s.length();
        for(int i = 0; i < sLen; i++){
            char ch = s.charAt(i);
            if(!st.empty() && ch == st.peek()) st.pop();
            else st.push(ch);
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.empty()) {
            char ch = st.pop();
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            String str = rotate(s, i);
            if(isCorrect(str)) answer++;
        }
        return answer;
    }
    public String rotate(String s, int i) {
        return s.substring(i, s.length()) + s.substring(0, i);
    }
    public boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '[' || c == '(' || c == '{') stack.push(c);
            else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
            else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
            else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            else continue;
        }
        return stack.isEmpty();
    }
}
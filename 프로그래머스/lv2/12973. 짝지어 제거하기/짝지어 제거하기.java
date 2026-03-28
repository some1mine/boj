import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = arr[i];
            if(stack.isEmpty()) stack.push(c);
            else if(stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
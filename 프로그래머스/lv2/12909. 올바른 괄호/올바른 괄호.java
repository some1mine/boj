import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < arr.length ; i += 1) {
            if(arr[i] == '(') stack.push(arr[i]);
            else if(stack.size() > 0 && stack.peek() == '(') stack.pop();
            else return false;
        }
        if(stack.size() == 0) return true;

        return answer;
    }
}
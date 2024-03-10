import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(char c : number.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() < c && k-- > 0) stack.pop();
            stack.push(c);
        }
        while(k-- > 0) stack.pop();
        return stack.stream().map(c -> c + "").collect(Collectors.joining());
    }
}
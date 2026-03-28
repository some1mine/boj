import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i : arr) {
            if(stack.isEmpty() || stack.peek() != i) stack.push(i);
            else stack.pop();
        }
        if(stack.isEmpty()) return new int[]{-1};
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
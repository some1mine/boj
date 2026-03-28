import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        for(int i = 1 ; i <= order.length ; i++) {
            sub.push(i);
            while(!sub.isEmpty() && sub.peek() == order[answer]) {
                sub.pop(); answer++;
            }
        }
        return answer;
    }
}
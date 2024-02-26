import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, idx = 0;
        Stack<Integer> sub = new Stack<>();
        for(int i = 0 ; i < order.length ; i++) {
            sub.push(i + 1);
            while(!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop(); answer++; idx++;
            }
        }
        return answer;
    }
}
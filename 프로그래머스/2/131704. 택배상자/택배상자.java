import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, idx = 0;
        int[] arr = IntStream.rangeClosed(1, order.length).toArray();
        Stack<Integer> sub = new Stack<>();
        for(int i = 0 ; i < order.length ; i++) {
            if(order[idx] != i + 1) {
                if(idx < order.length && (sub.isEmpty() || sub.peek() != order[idx])) sub.push(i + 1);
                while(!sub.isEmpty() && idx < order.length && sub.peek() == order[idx]) {
                    sub.pop(); answer++; idx++;
                }
            } else {
                idx++; answer++;
                while(!sub.isEmpty() && idx < order.length && sub.peek() == order[idx]) {
                    sub.pop(); answer++; idx++;
                }
            }
        }
        return answer;
    }
}
import java.util.*;
import java.util.stream.*;

class Solution {
    public int answer = 0, idx = 0;
    public Stack<Integer> sub = new Stack<>();
    public int solution(int[] order) {
        for(int i = 0 ; i < order.length ; i++) {
            sub.push(i + 1);
            extractFromSub(order);
        }
        return answer;
    }
    public void extractFromSub(int[] order) {
        while(!sub.isEmpty() && idx < order.length && sub.peek() == order[idx]) {
            sub.pop(); answer++; idx++;
        }
    }
}
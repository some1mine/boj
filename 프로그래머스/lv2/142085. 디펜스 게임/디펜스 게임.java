import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < enemy.length && (n >= enemy[i] || k > 0) ; i++) {
            queue.offer(enemy[i]);
            if(n < enemy[i]) {
                n += queue.poll(); k--;  
            }
            n -= enemy[i]; answer++;
        }
        return answer;
    }
}
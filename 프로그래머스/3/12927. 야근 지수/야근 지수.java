import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) queue.add(work);
        while(n-- > 0) {
            queue.add(Math.max(queue.poll() - 1, 0));
        }
        while(!queue.isEmpty()) answer += (int) Math.pow(queue.poll(), 2);
        return answer;
    }
}
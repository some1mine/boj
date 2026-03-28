import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s: scoville) queue.add(s);

        int answer = 0;
        while (queue.size() > 1 && queue.peek() < K) {
            queue.add(queue.remove() + queue.remove() * 2);
            answer += 1;
         }

         return queue.peek() >= K ? answer : -1;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, time = 0, idx = 0, count = 0;
        boolean[] visited = new boolean[jobs.length];
        Arrays.sort(jobs, (x, y) -> {
            if(x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        PriorityQueue<Job> queue = new PriorityQueue<>();
        
        while(count < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) queue.add(new Job(jobs[idx][0], jobs[idx++][1]));
            if(queue.isEmpty()) time = jobs[idx][0];
            else {
                Job cur = queue.poll();
                answer += cur.amount + time - cur.arrivalTime;
                time += cur.amount;
                count++;
            }
        }
        return answer / jobs.length;
    }
    class Job implements Comparable<Job> {
        int arrivalTime, amount;
        
        public Job(int arrivalTime, int amount) {
            this.arrivalTime = arrivalTime;
            this.amount = amount;
        }
        
        @Override
        public int compareTo(Job o) {
            return this.amount - o.amount;
        }
    }
}
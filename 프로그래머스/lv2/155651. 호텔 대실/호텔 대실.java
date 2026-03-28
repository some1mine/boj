import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for (String[] book : book_time) {            
            String[] starts = book[0].split(":"),  ends = book[1].split(":");                        
            int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1])
                , end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 1;                       
            if (queue.isEmpty()) {                
                answer++;                
                queue.offer(new int[]{start, end});                
                continue;            
            }                         
            int[] prev = queue.poll();                        
            int prevStart = prev[0];            
            int prevEnd = prev[1];                        
            if (start >= prevEnd) {                
                queue.offer(new int[]{start, end});            
            } else {                
                answer++;                
                queue.offer(new int[]{start, end});                
                queue.offer(prev);            
            }        
        }
        return answer;
    }
}
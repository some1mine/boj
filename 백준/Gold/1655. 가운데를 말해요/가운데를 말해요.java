import java.io.*;
import java.util.*;
import java.util.stream.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        while(n-- > 0) {
            int num = Integer.parseInt(reader.readLine());
            if(leftQueue.size() == rightQueue.size()) leftQueue.offer(num);
            else rightQueue.offer(num);
            if(!rightQueue.isEmpty() && leftQueue.peek() > rightQueue.peek()) {
                int small = rightQueue.poll(), big = leftQueue.poll();
                leftQueue.offer(small); rightQueue.offer(big);
            }
            sb.append(leftQueue.peek()).append("\n");
        }
        System.out.print(sb);
    }
}
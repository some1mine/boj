import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            int x = Integer.parseInt(reader.readLine());
            if(x == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n"); continue;
            }
            queue.offer(x);
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- >0) {
            int input = Integer.parseInt(reader.readLine());
            if(input == 0 && queue.isEmpty()) sb.append(0).append("\n");
            else if(input == 0) sb.append(queue.poll()).append("\n");
            else queue.offer(input);
        }
        System.out.print(sb);
    }
}
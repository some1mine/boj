import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] edgeCount = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<Integer>();
        while(m-- > 0) {
            st = new StringTokenizer(reader.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
            graph[from].add(to); edgeCount[to]++;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) {
            if(edgeCount[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int i : graph[cur]) {
                edgeCount[i]--;
                if(edgeCount[i] == 0) queue.offer(i);
            }
        }
        System.out.print(sb);
    }
}
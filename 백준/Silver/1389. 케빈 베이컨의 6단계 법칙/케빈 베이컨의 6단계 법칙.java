import java.io.*;
import java.util.*;
 
public class Main {
    public static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        List<Integer>[] relations = new ArrayList[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) relations[i] = new ArrayList<>();
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!relations[a].contains(b)) {
                relations[a].add(b); relations[b].add(a);    
            } 
        }
        int idx = -1; long min = Long.MAX_VALUE;
        for(int i = 1 ; i < n + 1 ; i++) {
            long bacon = getBacon(relations, i);
            if(bacon < min) {
                min = bacon; idx = i;
            }
        }
        System.out.print(idx);
    }
    public static long getBacon(List<Integer>[] relations, int num) {
        long[] steps = new long[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
 
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : relations[cur]) {
                if(steps[i] == 0 && i != num) {
                    steps[i] = steps[cur] + 1;
                    queue.offer(i);
                }
            }
        }
        return Arrays.stream(steps).sum();
    } 
}
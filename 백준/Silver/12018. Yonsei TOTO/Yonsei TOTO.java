import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int p = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);            
            if(p < l) queue.offer(1);
            else queue.offer(arr[p - l]);
        }
        while(!queue.isEmpty() && m > 0) {
            int cur = queue.poll();
            if(m >= cur) {
                answer++; m -= cur;
            }
        }
        System.out.print(answer);
    }
}
import java.io.*;
import java.util.*;

 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getMinOperation(a, b)).append("\n");
        }
        System.out.print(sb);
    }
    public static String getMinOperation(int a, int b) {
        String[] dp = new String[10000];
        Arrays.fill(dp, "$".repeat(100000));
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        dp[a] = "";

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == b) return dp[b];
            
            int d = (cur << 1) % 10000;
            int s = cur == 0 ? 9999 : cur - 1;
            int l = (cur % 1000) * 10 + (cur / 1000);
            int r = (cur / 10) + (cur % 10) * 1000;

            if(dp[d].length() > dp[cur].length() + 1) {
                dp[d] = dp[cur] + "D"; queue.offer(d);
            }
            if(dp[s].length() > dp[cur].length() + 1) {
                dp[s] = dp[cur] + "S"; queue.offer(s);
            }
            if(dp[l].length() > dp[cur].length() + 1) {
                dp[l] = dp[cur] + "L"; queue.offer(l);
            }
            if(dp[r].length() > dp[cur].length() + 1) {
                dp[r] = dp[cur] + "R"; queue.offer(r);
            }
        }
        return dp[b];
    }
}
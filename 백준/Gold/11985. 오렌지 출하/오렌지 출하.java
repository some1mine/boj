import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] nmk = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] oranges = new long[(int)(nmk[0] + 1)];
        long[] dp = new long[(int)(nmk[0] + 1)];
        for(int i = 1 ; i <= nmk[0] ; i++) {
            oranges[i] = Integer.parseInt(reader.readLine()); 
            dp[i] = nmk[2] * i;
        }
        for(int i = 0 ; i < nmk[0] ; i++) {
            long min = oranges[i + 1], max = oranges[i + 1];
            for(int j = 1 ; j <= nmk[1] && i + j <= nmk[0] ; j++) {
                min = Math.min(min, oranges[i + j]); max = Math.max(max, oranges[i + j]);
                dp[i + j] = Math.min(dp[i + j], dp[i] + nmk[2] + j * (max - min));
            }
        }
        System.out.print(dp[(int)nmk[0]]);
    }
}
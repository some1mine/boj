import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static Integer[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            getLength(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) max = Math.max(max, dp[i]);
        System.out.println(max);
        reader.close();
    }
    private static int getLength(int n) {
        if (dp[n] == null) {
            dp[n] = 1;
            for (int i = n - 1; i > -1; i--) {
                if(arr[i] < arr[n]) dp[n] = Math.max(dp[n], getLength(i) + 1);
            }
        }
        return dp[n];
    }
}
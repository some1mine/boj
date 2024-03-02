import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && a == b && b == c) break;
            sb.append("w(" + a + ", " + b + ", " + c + ")" + " = " + w(a, b, c) + "\n");
        }
        System.out.print(sb);
    }
    public static int w(int a, int b, int c) {
        if(inRange(a, b, c) && dp[a][b][c] != 0) return dp[a][b][c];
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if(a < b && b < c) return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
    public static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
	}
}
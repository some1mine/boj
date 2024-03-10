import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long k = Long.parseLong(reader.readLine()), left = 1, right = k;
        
        while (left < right) {
            if(k > getCount(left, right, n)) left = (left + right) / 2 + 1;
            else right = (left + right) / 2;
        }
        System.out.print(left);
    }
    public static long getCount(long left, long right, int n) {
        long answer = 0;
        for(int i = 1 ; i <= n ; i++) answer += Math.min((left + right) / 2 / i, n);
        return answer;
    }
}
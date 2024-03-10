import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long k = Long.parseLong(reader.readLine()), start = 1, end = k;
        
        while (start < end) {
            long mid = (start + end) / 2, cnt = 0;
            for (int i = 1; i <= n; i++) cnt += Math.min(mid / i, n);
            if(k > cnt) start = mid + 1;
            else end = mid;
        }
        System.out.print(start);
    }
}
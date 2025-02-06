import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        n = nm[0]; m = nm[1];
        arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int cur = -1, step = 10001;
        while(step > 0) {
            while(cur + step <= 10000 && cnt(cur + step) > nm[1]) cur += step;
            step >>= 1;
        }
        System.out.print(cur + 1);
    }

    private static int cnt(int k) {
        int min =  arr[0], max = arr[0], cnt = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]); max = Math.max(max, arr[i]);
            if(max - min > k) {
                min = arr[i]; max = arr[i]; cnt += 1;
            }
        }
        return cnt + 1;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nc = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[nc[0]];
        for(int i = 0 ; i < nc[0] ; i++) arr[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(arr);
        System.out.print(solution(arr, nc[0], nc[1]));
    }
    public static int solution(int[] arr, int n, int c) {
        int cur = -1, step = arr[n - 1] + 1;
        while(step > 0) {
            while(cur + step <= arr[n - 1] + 1 && cnt(arr, n, cur + step) >= c) cur += step;
            step >>= 1;
        }
        return cur;
    }
    public static int cnt(int[] arr, int n, int d) {
        int cnt = 1, start = 0;
        for(int i = 1 ; i < n ; i++) {
            if(arr[i] - arr[start] >= d) {
                start = i; cnt += 1;
            }
        }
        return cnt;
    }
}
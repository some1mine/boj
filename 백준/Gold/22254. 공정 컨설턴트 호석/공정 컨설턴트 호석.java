import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
        int[] times = new int[n];
        st = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < n; i++) times[i] = Integer.parseInt(st.nextToken());

        int start = 1, end = n, answer = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            long time = getTime(mid, times);
            if (time <= x) {
                end = mid - 1; answer = Math.min(answer, mid);
            } else if (time > x) start = mid + 1;
        }
        System.out.print(answer);
    }

    private static long getTime(int count, int[] times) {
        PriorityQueue<Integer> lines = new PriorityQueue<>();
        int num = 0;
        while (num < count) lines.offer(times[num++]);
        while (num < times.length) lines.offer(lines.poll() + times[num++]);
        return lines.stream().mapToLong(n -> n).max().getAsLong();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        int[] targets = new int[m];
        for(int i = 0 ; i < m ; i++) targets[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            System.out.println(contains(arr, targets[i]));
        }
        reader.close();
    }

    private static int contains(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int half = (start + end) / 2;
            if(arr[half] < target) start = half + 1;
            if(arr[half] > target) end = half - 1;
            if(arr[half] == target) return 1;
        }
        return 0;
    }
}

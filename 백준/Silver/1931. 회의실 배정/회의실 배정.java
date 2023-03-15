import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (x, y) -> {
            if(x[1] == y[1]) return x[0] - y[0];
            return x[1] - y[1];
        });
        
        int time = 0, answer = 0;
        for(int i =0 ; i < n ; i++) {
            if(time <= arr[i][0]) {
                time = arr[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
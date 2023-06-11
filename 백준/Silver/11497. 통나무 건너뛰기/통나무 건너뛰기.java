import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for(int num = 0 ; num < number ; num++) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            int[] newArr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                if(i % 2 == 0) newArr[i / 2] = arr[i];
                else newArr[n - i / 2 - 1] = arr[i];
            }
            int answer = Math.abs(newArr[n - 1] - newArr[0]);
            for(int i = 1 ; i < n ; i++) answer = Math.max(Math.abs(newArr[i] - newArr[i - 1]), answer);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
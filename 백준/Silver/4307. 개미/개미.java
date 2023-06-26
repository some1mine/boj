import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for(int caseNum = 0 ; caseNum < T ; caseNum++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int length = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(reader.readLine());
            builder.append(getMin(arr, length, n)).append(" ").append(getMax(arr, length , n)).append("\n");
        }
        System.out.print(builder);
    }
    public static int getMin(int[] arr, int length, int n) {
        int pivot = length % 2 == 0 ? length / 2 : length / 2 + 1;
        int answer = 0;
        for(int i = 0 ; i < n ; i++) {
            if(arr[i] >= pivot) answer = Math.max(length - arr[i], answer);
            else answer = Math.max(arr[i], answer);
        }
        return answer;
    }
    public static long getMax(int[] arr, int length, int n) {
        int pivot = length % 2 == 0 ? length / 2 : length / 2 + 1;
        long answer = 0;
        for(int i = 0 ; i < n ; i++) {
            if(arr[i] >= pivot) answer = Math.max(arr[i], answer);
            else answer = Math.max(length - arr[i], answer);
        }
        return answer;
    } 
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(reader.readLine());
        int left = 0, right = arr[n - 1];
        Arrays.sort(arr);
        while(left <= right) {
            if(getCount(left, right, arr) < c) right = (left + right) / 2 - 1;
            else left = (left + right) / 2 + 1;
        }
        System.out.print(right);
    }
    public static int getCount(int left, int right, int[] arr) {
        int answer = 1, cur = arr[0], mid = (left + right) / 2; 
        for(int i : arr) {
            if(i - cur >= mid) {
                answer++; cur = i;
            }
        }
        return answer;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nc = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[nc[0]];
        for(int i = 0 ; i < nc[0] ; i++) arr[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(arr);
        int left = 0, right = arr[nc[0] - 1];
        while(left <= right) {
            if(count(left, right, arr) < nc[1]) right = (left + right) / 2 - 1;
            else left = (left + right) / 2 + 1;
        }
        System.out.print(right);
    }
    public static int count(int left, int right, int[] arr) {
        int count = 1, cur = arr[0], mid = (left + right) / 2;
        for(int i : arr) {
            if(i - cur >= mid) {
                count++; cur = i;
            }
        }
        return count;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[1001];
        long sum = 0; long take = 0;
        for(int i : arr) result[i]++;
        for(int i = 0 ; i < result.length ; i++) {
            for(int j = 0 ; j < result[i] ; j++) {
                take = take + i;
                sum += take;
            }
        }
        System.out.println(sum);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        permutation(0, nm[1], arr, new int[nm[1]]);
        System.out.println(sb);
    }
    public static void permutation(int idx, int m, int[] arr, int[] results) {
        if (idx == m) {
            for (int i : results) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for (int n : arr) {
            results[idx] = n;
            permutation(idx + 1, m, arr, results);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        permutation(0, nm[1], arr, new int[nm[1]]);
        writer.flush();
        writer.close();
    }
    public static void permutation(int idx, int m, int[] arr, int[] results) throws IOException {
        if (idx == m) {
            for (int i : results) writer.append(i + " ");
            writer.append("\n");
            return;
        }

        for (int n : arr) {
            results[idx] = n;
            permutation(idx + 1, m, arr, results);
        }
    }
}
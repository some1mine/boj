import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" "), arr2 = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr1[i].equals("0")) queue.offer(Integer.parseInt(arr2[i]));
        }
        int m = Integer.parseInt(br.readLine());
        String[] arr3 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr3) {
            queue.offer(Integer.parseInt(s));
            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

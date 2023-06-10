import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        boolean[] visited = new boolean[9];
        for(int i = 0 ; i < 9 ; i++) arr[i] = scanner.nextInt();
        combination(arr, visited, 0, 9, 7);
    }
    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0 && isCorrect(arr, visited, n)) {
            for(int i = 0 ; i < n ; i++) {
                if(visited[i]) System.out.println(arr[i]);
            }
            System.exit(0);
        }
        if(depth == n) return;
        
        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);
    }
    public static boolean isCorrect(int[] arr, boolean[] visited, int n) {
        int result = 0;
        for(int i = 0 ; i < n ; i++) {
            if(visited[i]) result += arr[i];
        }
        return result == 100;
    }
}
import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] result = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(possible(arr, i, j)) result[i][j] = 1;
                else result[i][j] = 0;
            }
        }
        for(int[] ar : result) {
            for(int i : ar) System.out.print(i + " ");
            System.out.println();
        }
    }
    public static boolean possible(int[][] arr, int num1, int num2) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        for(int i = 0 ; i < arr[num1].length ; i++) {
            if(arr[num1][i] == 1) {
            	queue.offer(i); visited[i] = true;
            }
        }
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(num == num2) return true;
            for(int i = 0 ; i < arr[num].length ; i++) {
                if(!visited[i] && arr[num][i] == 1) {
                	queue.add(i); visited[i] = true;
                }
            }
        }
        return false;
    }
}
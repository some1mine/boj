import java.io.*;
import java.util.*;

public class Main {
    public static int white = 0, blue = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] arr =  new int[n][n];
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(arr, n, 0, 0);
        System.out.print(white + "\n" + blue);
    }
    public static void solution(int[][] arr, int length, int startX, int startY) {
        if(isEven(arr, length, startX, startY)) {
            if(arr[startY][startX] == 0) white++;
            else blue++;
            return;
        }
        for(int i = startY ; i < startY + length ; i += length) {
            for(int j = startX ; j < startX + length ; j += length) {
                if(!isEven(arr, length, startX, startY)) {
                    solution(arr, length / 2, startX, startY);
                    solution(arr, length / 2, startX + length / 2, startY);
                    solution(arr, length / 2, startX, startY + length / 2);
                    solution(arr, length / 2, startX + length / 2, startY + length / 2);
                }
            }
        }
    }
    public static boolean isEven(int[][] arr, int length, int startX, int startY) {
        for(int i = startY ; i < startY + length ; i++) {
            for(int j = startX ; j < startX + length ; j++) {
                if(arr[i][j] != arr[startY][startX]) return false;
            }
        }
        return true;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] arr = new int[len][2];
        String[] input;
        int[] tmp;
        
        for(int i = 0 ; i < len ; i++) {
            input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        
        for(int[] i : arr) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
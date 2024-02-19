import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[len][2];
        String[] tmp;
        for(int i = 0 ; i < len ; i++) {
            tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        int[] answer = new int[len];
        for(int i = 0 ; i < len ; i++) {
            answer[i] = arr[i][1] - arr[i][0];
        }
        
        for(int i : answer) {
            int j = (int)Math.sqrt(i); 
            if(j * j == i) System.out.println(2 * j - 1);  
            else if(j * j + j >= i) System.out.println(2 * j); 
            else System.out.println(2 * j + 1); 
        }
    }
}
import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()), ord = 0;
        int[] arr = new int[n];
        for(int i = 0 ; i < 1_000_000_000 && ord < n ; i++) {
            if(Integer.toString(i).contains("666")) arr[ord++] = i;
        }
        System.out.print(arr[n - 1]);
    }
}
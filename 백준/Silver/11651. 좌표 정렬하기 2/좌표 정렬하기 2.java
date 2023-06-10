import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(br.readLine());
        int[][] arr = new int[len][2];
        String[] tmp = new String[2];
        
        for(int i = 0 ; i < len ; i++) {
            tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        
        int[] numForCng;
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        for(int[] i : arr) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
    
    public static boolean haveToChange(int[] a, int[] b) {
        boolean ret = false;
        if(a[1] > b[1]) ret = true;
        else if(a[1] == b[1] && a[0]  > b[0]) ret = true;
        
        return ret;
    }
}
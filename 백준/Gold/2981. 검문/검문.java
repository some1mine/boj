import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(arr);
        int gcd = arr[1] - arr[0];
        for(int i = 2; i < n ; i++) {
            gcd = getGcd(arr[i] - arr[i - 1], gcd);
        }
        for(int i = 2 ; i <= gcd; i++) {
            if(gcd % i == 0) System.out.print(i + " ");
        }
    }
    public static int getGcd(int num1, int num2) {
        while(num2 > 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }
}
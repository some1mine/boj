import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = scanner.nextInt();
        solution(arr);
    }
    private static void solution(int[] arr) {
        int standard = arr[0];
        for(int i = 1; i < arr.length ; i++) {
            int gcd = getGCD(arr[0], arr[i]);
            System.out.println((arr[0] / gcd) + "/" + (arr[i] / gcd));
        }
    }
    private static int getGCD(int a, int b) {
        for(int i = a ; i > 0 ; i--) {
            if(a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
}
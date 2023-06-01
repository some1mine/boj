import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = i + 1;
        for(int i = 0 ; i < m ; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            swap(a, b);
        }
        for(int i : arr) System.out.print(i + " ");
    }
    public static void swap(int a, int b) {
        int tmp = arr[a - 1]; arr[a - 1] = arr[b - 1]; arr[b - 1] = tmp;
    }
}
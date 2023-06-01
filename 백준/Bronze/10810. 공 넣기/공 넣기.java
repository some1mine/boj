import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < m ; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            for(int idx = a - 1 ; idx < b ; idx++) arr[idx] = c;
        }
        for(int i : arr) System.out.print(i + " ");
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][4];
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr, (a, b) -> {
            if(a[1] * a[2] * a[3] == b[1] * b[2] * b[3] && a[1] + a[2] + a[3] == b[1] + b[2] + b[3]) return a[0] - b[0];
            if(a[1] * a[2] * a[3] == b[1] * b[2] * b[3]) return a[1] + a[2] + a[3] - b[1] - b[2] - b[3];
            return a[1] * a[2] * a[3] - b[1] * b[2] * b[3];
        });
        for(int i = 0 ; i < 2 ; i++) System.out.print(arr[i][0] + " ");
        System.out.print(arr[2][0]);
    }
}
import java.util.*;

public class Main {
    public static int white = 0, blue = 0;
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        divide(0, 0, n);
        System.out.println(white + "\n" + blue);
    }
    public static void divide(int num1, int num2, int n) {
        if(isFlatColor(num1, num2, n)) {
            if(arr[num1][num2] == 0) white++;
            else blue++;
            return;
        }
        divide(num1, num2, n / 2);
        divide(num1, num2 + n / 2, n / 2);
        divide(num1 + n / 2, num2, n / 2);
        divide(num1 + n / 2, num2 + n / 2, n / 2);
    }

    public static boolean isFlatColor(int num1, int num2, int n) {
        int color = arr[num1][num2];
        for(int i = num1 ; i < num1 + n ; i++) {
            for(int j = num2 ; j < num2 + n ; j++) {
                if(arr[i][j] != color) return false;
            }
        }
        return true;
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] arr = new boolean[1001];
        arr[1] = true; arr[3] = true; arr[4] = true;
        for(int i = 5 ; i < 1001 ; i++) {
            if(!arr[i - 1] || !arr[i - 3] || !arr[i - 4]) arr[i] = true;
        }
        System.out.println(arr[n] ? "SK" : "CY");
        scanner.close();
    }
}
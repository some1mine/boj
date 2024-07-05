import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nm = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[nm[1]][2];
        for(int i = 0 ; i < nm[1] ; i++) arr[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(Math.min(
            Math.min(
            nm[0] / 6 * Arrays.stream(arr).mapToInt(a -> a[0]).min().getAsInt() + nm[0] % 6 * Arrays.stream(arr).mapToInt(a -> a[1]).min().getAsInt(), 
            (nm[0] / 6 + 1) * Arrays.stream(arr).mapToInt(a -> a[0]).min().getAsInt()
        ), nm[0] * Arrays.stream(arr).mapToInt(a -> a[1]).min().getAsInt()));
        scanner.close();
    }
}
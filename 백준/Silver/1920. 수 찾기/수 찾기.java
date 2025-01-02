import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int m = Integer.parseInt(scanner.nextLine());
        int[] arr2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i : arr2) binarySearch(arr1, i);
    }
    public static void binarySearch(int[] arr, int target) {
        int cur = -1, step = arr.length;
        while(step > 0) {
            while(cur + step < arr.length && arr[cur + step] <= target) cur += step;
            step /= 2;
        }
        System.out.println(cur < 0 || cur >= arr.length || arr[cur] != target ? 0 : 1);
    }
}
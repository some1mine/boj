import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] arr1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        scanner.nextLine();
        int[] arr2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i : arr2) System.out.println(binarySearch(arr1, i));
    }
    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] > target) end = mid - 1;
            if(arr[mid] < target) start = mid + 1;
            if(arr[mid] == target) return 1;
        }
        return 0;
    }
}
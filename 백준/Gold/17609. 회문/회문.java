import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextLine();
        for (String s : arr) System.out.println(isPalindrome(s.toCharArray(), -1, s.length(), 0));
    }
    private static int isPalindrome(char[] arr, int start, int end, int count) {
        if (count > 1) return 2;
        while (++start <= --end) {
            if (arr[start] != arr[end]) {
                if (isPalindrome(arr, start - 1, end, count + 1) == 0 || isPalindrome(arr, start, end + 1, count + 1) == 0) return 1;
                return 2;
            }
        }
        return 0;
    }
}

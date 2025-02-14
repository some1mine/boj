import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextLine();
        for (String s : arr) System.out.println(isPalindrome(s, 0));
    }
    private static int isPalindrome(String s, int count) {
        if (count > 1) return 2;
        int start = -1, end = s.length();
        char[] arr = s.toCharArray();
        while(++start <= --end) {
            if (arr[start] != arr[end]) {
                StringBuilder sb1 = new StringBuilder(s), sb2 = new StringBuilder(s);
                sb1.deleteCharAt(start); sb2.deleteCharAt(end);
                if (isPalindrome(sb1.toString(), count + 1) == 0 || isPalindrome(sb2.toString(), count + 1) == 0) return 1;
                return 2;
            }
        }
        return 0;
    }
}

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        IntStream.range(0, b).forEach(i -> System.out.println("*".repeat(a)));
    }
}
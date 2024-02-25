import java.util.stream.*;

class Solution {
    public int[] solution(int n, int m) {
       int gcd = IntStream.rangeClosed(1, Math.min(n, m)).filter(i -> n % i == 0 && m % i == 0).max().getAsInt();
        return new int[]{gcd, n * m / gcd};
    }
}
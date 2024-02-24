class Solution {
    public int[] solution(int n, int m) {
        int gcd = 0, max = Math.max(n, m);
        for(int i = 1 ; i < max ; i++) gcd = n % i == 0 && m % i == 0 ? i : gcd;
        return new int[]{gcd, n * m / gcd};
    }
}
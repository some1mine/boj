class Solution {
    public int[] solution(int n, int m) {
        int gcd = 1, min = Math.max(n, m);
        for(int i = 2 ; i <= min ; i++) gcd = n % i == 0 && m % i == 0 ? i : gcd;
        return new int[]{gcd, n * m / gcd};
    }
}
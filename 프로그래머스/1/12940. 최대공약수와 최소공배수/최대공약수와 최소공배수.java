class Solution {
    public int[] solution(int n, int m) {
        int max = 0;
        for(int i = 1 ; i < (n > m ? n : m) ; i++) max = (n % i == 0 && m % i == 0 && max < i) ? i : max;
        return new int[]{max, n * m / max};
    }
}
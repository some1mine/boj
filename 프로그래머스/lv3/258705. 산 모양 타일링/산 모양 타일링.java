class Solution {
    public int solution(int n, int[] tops) {
        int[][] answers = new int[n][2]; answers[0][0] = tops[0] + 2; answers[0][1] = tops[0] + 1;
        for (int i = 1 ; i < n ; i++) {
            answers[i][1] = (answers[i - 1][0] + answers[i - 1][1]) % 10007;
            answers[i][0] = ((tops[i] + 2) * answers[i - 1][0] + (tops[i] + 1) * answers[i - 1][1]) % 10007;
        }
        return (answers[n - 1][0] + answers[n - 1][1]) % 10007;
    }
}
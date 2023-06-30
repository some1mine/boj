class Solution {
    public int idx = 0;
    public int[][] answer;
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        hanoi(n, 1, 2, 3);
        return answer;
    }
    public void hanoi(int n, int from, int way, int to) {
        if(n == 1) {
            answer[idx++] = new int[]{from, to};
            return;
        }
        hanoi(n - 1, from, to, way);
        answer[idx++] = new int[]{from, to};
        hanoi(n - 1, way, from, to);
    }
}
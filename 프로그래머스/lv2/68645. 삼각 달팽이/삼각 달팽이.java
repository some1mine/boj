class Solution {
    public int[] dirX = {0, 1, -1};
    public int[] dirY = {1, 0, -1};
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] triangle = new int[n][n];
        int v = 1, x = 0, y = 0, d = 0, idx = 0;
        while(true) {
            triangle[y][x] = v++;
            int dx = x + dirX[d], dy = y + dirY[d];
            if(dy == n || dx == n || dy == -1 || dx == -1 || triangle[dy][dx] != 0) {
                d = (d + 1) % 3;
                dx = x + dirX[d]; dy = y + dirY[d];
                if(dy == n | dx == n || dy == -1 || dx == -1 || triangle[dy][dx] != 0) break;
            }
            x = dx; y = dy;
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) answer[idx++] = triangle[i][j];
        }
        return answer;
    }
}
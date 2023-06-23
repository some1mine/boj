class Solution {
    public int[] dx = {0, 1, -1};
    public int[] dy = {1, 0, -1};
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int v = 1, x = 0, y = 0, d = 0;
        while(true) {
            arr[y][x] = v++;
            int nx = x + dx[d], ny = y + dy[d];
            if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d]; ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) break;
            }
            x = nx; y = ny;
        }
        int[] answer = new int[v - 1];
        int idx = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}
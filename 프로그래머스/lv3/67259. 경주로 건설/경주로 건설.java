import java.util.*;

class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int solution(int[][] board) {
        int n = board.length;
        // 오는 경우 중 네 방향 경우의 수 가운데 최소한의 비용을 저장, dp배열 같은 느낌
        int[][][] cost = new int[n][n][4]; 
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        }        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < 4 ; i++) cost[0][0][i] = 0;
        queue.offer(new int[]{0, 0, -1, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == n - 1 && cur[1] == n - 1) continue; 
            for(int i = 0 ; i < 4 ; i++) {
                int x = cur[0] + directions[i][0], y = cur[1] + directions[i][1];
                if(x < 0 || y < 0 || x >= n || y >= n || board[x][y] == 1) continue;
                int newCost = cur[3] + 100;
                if(cur[2] != -1 && cur[2] != i) newCost += 500;
                if(cost[x][y][i] > newCost) { // 적은 비용으로 올 수 있을 때만 갱신되므로 무한루프 X
                    cost[x][y][i] = newCost;
                    queue.offer(new int[]{x, y, i, newCost});
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < 4 ; i++) answer = Math.min(answer, cost[n - 1][n - 1][i]); // 네 방향 중 최소
        return answer;
    }
}
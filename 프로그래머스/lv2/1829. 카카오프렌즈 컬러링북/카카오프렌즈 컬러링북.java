import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean[][] visited;
    public int[] answer = new int[2];
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[] solution(int m, int n, int[][] picture) {
        picture = picture.clone(); visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) bfs(picture, i, j);
            }
        }   
        return answer;
    }
    public void bfs(int[][] picture, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y}); visited[x][y] = true; 
        int area = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll(); area++;
            for(int[] direction : directions) {
                int dx = cur[0] + direction[0], dy = cur[1] + direction[1];
                if(dy < 0 || dx < 0 || dx >= picture.length || dy >= picture[0].length) continue;
                if(!visited[dx][dy] && picture[dx][dy] == picture[cur[0]][cur[1]]) {
                    visited[dx][dy] = true; queue.offer(new int[]{dx, dy});
                }
            }
        }
        answer[1] = Math.max(answer[1], area); answer[0]++;
    }
}
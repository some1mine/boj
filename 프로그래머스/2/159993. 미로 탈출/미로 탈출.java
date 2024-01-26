import java.util.*;

class Solution {
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int solution(String[] maps) {
        
        char[][] map = Arrays.stream(maps).map(m -> m.toCharArray()).toArray(char[][]::new);
        int[] startPoint = getPoint(map, 'S'), leverPoint = getPoint(map, 'L');
        
        int count1 = bfs(map, startPoint, 'L'), count2 = bfs(map, leverPoint, 'E');
        if(count1 == -1 || count2 == -1) return -1;
        
        return count1 + count2;
    }
    public int bfs(char[][] map, int[] startPoint, char endMark) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startPoint[0], startPoint[1], 0}); visited[startPoint[0]][startPoint[1]] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(map[cur[0]][cur[1]] == endMark) return cur[2];
            for(int[] direction : directions) {
                int dy = cur[0] + direction[0], dx = cur[1] + direction[1];
                if(dy < 0 || dy >= map.length || dx < 0 || dx >= map[0].length) continue;
                if(!visited[dy][dx] && map[dy][dx] != 'X') {
                    queue.offer(new int[]{dy, dx, cur[2] + 1}); visited[dy][dx] = true;
                }
            }
        }
        return -1;
    }
    public int[] getPoint(char[][] map, char target) {
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
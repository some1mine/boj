import java.util.*;

class Solution {
    public boolean[][] visited;
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[] solution(String[] maps) {
        return getResults(Arrays.stream(maps).map(m -> m.toCharArray()).toArray(char[][]::new));
    }
    public int[] getResults(char[][] maps) {
        List<Integer> list = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length];
        for(int i = 0 ; i < maps.length ; i++) {
            for(int j = 0 ; j < maps[i].length ; j++) {
                if(Character.isDigit(maps[i][j]) && !visited[i][j]) list.add(bfs(maps, i, j));
            }
        }
        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(i -> i).sorted().toArray();
    }
    public int bfs(char[][] maps, int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        int answer = maps[startY][startX] - '0';
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] direction : directions) {
                int dy = cur[0] + direction[0], dx = cur[1] + direction[1];
                if(dy < 0 || dy >= maps.length || dx < 0 || dx >= maps[0].length || visited[dy][dx]) continue;
                if(Character.isDigit(maps[dy][dx])) {
                    queue.offer(new int[]{dy, dx}); answer += maps[dy][dx] - '0'; visited[dy][dx] = true;
                }
            }
        }
        return answer;
    }
}
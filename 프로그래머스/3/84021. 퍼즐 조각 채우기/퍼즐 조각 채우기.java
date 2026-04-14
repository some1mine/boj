import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0; List<int[][]> block = collect(table, 1), target = collect(game_board, 0);
        boolean[] visitedB = new boolean[block.size()], visitedT = new boolean[target.size()];
        for(int i = 0 ; i < block.size() ; i++) {
            int[][] t = block.get(i);
            for(int j = 0 ; j < target.size() ; j++) {
                int[][] b = target.get(j);
                for(int k = 0 ; k < 4 ; k++) {
                    if(!visitedB[i] && !visitedT[j] && isSame(t, b)) {
                        answer += (int) Arrays.stream(t).flatMapToInt(Arrays::stream).sum(); 
                        visitedB[i] = true; visitedT[j] = true; break;
                    }
                    t = rotate(t);
                }
            }
        }
        return answer;
    }
    public boolean isSame(int[][] t, int[][] b) {
        if(t.length != b.length || t[0].length != b[0].length) return false;
        for(int i = 0 ; i < t.length ; i++) {
            for(int j = 0 ; j < b.length ; j++) {
                if(t[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
    public List<int[][]> collect(int[][] table, int target) {
        List<int[][]> answer = new ArrayList<>();
        boolean[][] visited = new boolean[table.length][table[0].length];
        for(int i = 0 ; i < table.length ; i++) {
            for(int j = 0 ; j < table[i].length ; j++) {
                if(visited[i][j] || table[i][j] != target) continue;
                Queue<int[]> queue = new ArrayDeque<>(); List<int[]> block = new ArrayList<>();
                queue.offer(new int[]{i, j}); block.add(new int[]{i, j}); visited[i][j] = true;
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for(int[] d : directions) {
                        int dy = cur[0] + d[0], dx = cur[1] + d[1];
                        if(dy < 0 || dx < 0 || dy >= table.length || dx >= table.length || visited[dy][dx]) continue;
                        visited[dy][dx] = true;
                        if(table[dy][dx] != target) continue;
                        queue.offer(new int[]{dy, dx}); block.add(new int[]{dy, dx});
                    }
                }
                answer.add(make(block));
            }
        }
        return answer;
    }
    public int[][] make(List<int[]> block) {
        int maxY = -1, maxX = -1, minY = 50, minX = 50, max = 0;
        for(int[] b : block) {
            maxY = Math.max(maxY, b[0]); maxX = Math.max(maxX, b[1]); 
            minY = Math.min(minY, b[0]); minX = Math.min(minX, b[1]);
        }
        maxY -=  minY > 0 ? minY : 0; maxX -= minX > 0 ? minX : 0; max = Math.max(maxY, maxX);
        int[][] answer = new int[max + 1][max + 1];
        for(int[] b : block) answer[Math.min(b[0] - minY, b[0])][Math.min(b[1] - minX, b[1])] = 1;
        return answer; 
    }
    public int[][] rotate(int[][] origin) {
        int[][] answer = new int[origin.length][origin.length];
        for(int i = 0 ; i < origin.length ; i++){
            for(int j = 0 ; j < origin.length ; j++){
                answer[i][j] = origin[origin.length - j - 1][i];
            }
        }
        while(true){
            int zeroCnt = (int) IntStream.range(0, origin.length).filter(i -> answer[i][0] == 0).count();
            if(zeroCnt != origin.length) break;
            for(int i = 0 ; i < origin.length ; i++){
                for(int j = 1 ; j < origin[0].length ; j++) {
                    answer[i][j - 1] = answer[i][j];
                }
                answer[i][origin.length - 1] = 0;
            }
        }
        return answer;
    }
}
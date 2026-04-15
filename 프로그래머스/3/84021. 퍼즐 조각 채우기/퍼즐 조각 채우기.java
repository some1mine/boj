import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0; List<int[][]> block = collect(table, 1), target = collect(game_board, 0);
        boolean[] visitedB = new boolean[block.size()], visitedT = new boolean[target.size()];
        for(int i = 0 ; i < block.size() ; i++) {
            for(int j = 0 ; j < target.size() ; j++) {
                int[][] t = target.get(j), b = block.get(i);
                if(visitedB[i] || visitedT[j]) continue;
                for(int k = 0 ; k < 4 ; k++, t = rotate(t)) {
                    if(matches(t, b)) {
                        answer += (int) Arrays.stream(t).flatMapToInt(Arrays::stream).sum(); 
                        visitedB[i] = true; visitedT[j] = true; break;
                    }
                }
            }
        }
        return answer;
    }
    public boolean matches(int[][] t, int[][] b) {
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
                if (visited[i][j] || table[i][j] != target) continue;
                List<int[]> block = new ArrayList<>(); Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i, j}); visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll(); block.add(cur);
                    for (int[] d : directions) {
                        int ny = cur[0] + d[0], nx = cur[1] + d[1];
                        if (ny < 0 || nx < 0 || ny >= table.length || nx >= table.length || visited[ny][nx] || table[ny][nx] != target) continue;
                        visited[ny][nx] = true; queue.offer(new int[]{ny, nx});
                    }
                }
                answer.add(make(block));
            }
        }
        return answer;
    }
    public int[][] make(List<int[]> block) {
        int maxY = block.stream().map(a -> a[0]).mapToInt(i -> i).max().getAsInt(), 
            minY = block.stream().map(a -> a[0]).mapToInt(i -> i).min().getAsInt(),
            maxX = block.stream().map(a -> a[1]).mapToInt(i -> i).max().getAsInt(), 
            minX = block.stream().map(a -> a[1]).mapToInt(i -> i).min().getAsInt(),
            max = Math.max(maxY - minY, maxX - minX);
        int[][] answer = new int[max + 1][max + 1];
        for(int[] b : block) answer[b[0] - minY][b[1] - minX] = 1;
        return answer; 
    }
    public int[][] rotate(int[][] origin) {
        int[][] answer = new int[origin.length][origin.length];
        IntStream.range(0, origin.length).forEach(i -> IntStream.range(0, origin.length).forEach(j -> answer[i][j] = origin[origin.length - j - 1][i]));
        while(IntStream.range(0, origin.length).filter(i -> answer[i][0] == 0).count() == origin.length){
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
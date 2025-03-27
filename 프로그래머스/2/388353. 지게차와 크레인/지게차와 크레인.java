import java.util.*;

class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int solution(String[] storage, String[] requests) {
        int answer = storage.length * storage[0].length();
        char[][] store = Arrays.stream(storage).map(String::toCharArray).toArray(char[][]::new);
        for(String s : requests) answer -= calculate(store, s.charAt(0), s.length() == 2);
        return answer;
    }
    int calculate(char[][] storage, char request, boolean isAll) {
        int answer = 0; boolean[][] visited = new boolean[storage.length][storage[0].length];
        if(isAll) {
            for(int i = 0 ; i < storage.length ; i++) {
                for(int j = 0 ; j < storage[0].length ; j++) {
                    if(storage[i][j] == request) {
                        answer++; storage[i][j] = '\0';
                    }
                }
            }
            return answer;
        }
        for(int i = 0 ; i < storage.length ; i++) answer += bfs(storage, new int[]{i, 0}, new int[]{i, storage[0].length - 1}, request, visited);
        for(int i = 0 ; i < storage[0].length ; i++) answer += bfs(storage, new int[]{0, i}, new int[]{storage.length - 1, i}, request, visited);
        return answer;
    }
    int bfs(char[][] storage, int[] a, int[] b, char request, boolean[][] visited) {
        int answer = 0; Queue<int[]> queue = new LinkedList<>(); queue.offer(a); queue.offer(b);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll(); int y = cur[0], x = cur[1];
            if(storage[y][x] == '\0' && !visited[y][x]) {
                for(int[] d : directions) {
                    int dy = y + d[0], dx = x + d[1];
                    if(dy < 0 || dy >= storage.length || dx < 0 || dx >= storage[0].length) continue;
                    queue.offer(new int[]{dy, dx});
                }
            }
            if(storage[y][x] == request) {
                answer++; storage[y][x] = '\0';
            }
            visited[y][x] = true;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Dot> queue = new LinkedList<>();
        queue.offer(new Dot(0, 0, 1));
        maps[0][0] = 0;
        while(!queue.isEmpty()) {
            Dot dot = queue.poll();
            if(dot.x == maps.length - 1 && dot.y == maps[0].length - 1) {
                return dot.level;
            }
            for(int[] ord : directions) {
                int dx = dot.x + ord[0], dy = dot.y + ord[1];
                if(dx < 0 || dy < 0 || dx > maps.length - 1 || dy > maps[0].length - 1) continue;
                if(maps[dx][dy] == 0) continue;
                queue.offer(new Dot(dx, dy, dot.level + 1));
                maps[dx][dy] = 0;
            }
        }
        return -1;
    }
}
class Dot {
    int x;
    int y;
    int level;
    
    Dot(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
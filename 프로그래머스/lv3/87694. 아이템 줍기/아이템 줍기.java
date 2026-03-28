import java.util.*;

class Solution {
    public double[][] directions = {{0.5, 0}, {0, 0.5}, {-0.5, 0}, {0, -0.5}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Set<Dot> tmp = new HashSet<>(), set = new HashSet<>();
        for(int[] r : rectangle) {
            for(int i = r[0] ; i < r[2] ; i++) {
                tmp.add(new Dot(i + 0.5, r[1], -1)); tmp.add(new Dot(i + 0.5, r[3], -1));
            }
            for(int i = r[1] ; i < r[3] ; i++) {
                tmp.add(new Dot(r[0], i + 0.5, -1)); tmp.add(new Dot(r[2], i + 0.5, -1));
            }
        }
        out:for(Dot d : tmp) {
            for(int[] r : rectangle) {
                if(d.x > r[0] && d.x < r[2] && d.y > r[1] && d.y < r[3]) continue out;
            }
            set.add(d);
        }
        Queue<Dot> queue = new LinkedList<>(); queue.offer(new Dot(characterX , characterY, 0));
        while(!queue.isEmpty()) {
            Dot cur = queue.poll();
            if(cur.x == itemX && cur.y == itemY) return cur.d;
            for(double[] direction : directions) {
                Dot position = new Dot(direction[0] + cur.x, direction[1] + cur.y, -1);
                if(set.contains(position)) {
                    queue.offer(new Dot(cur.x + 2 * direction[0], cur.y + 2 * direction[1], cur.d + 1));
                    set.remove(position);
                }
            }
        }
        return -1;
    }
}

class Dot {
    double x, y; int d;
    public Dot(double x, double y, int d) {
        this.x = x; this.y = y; this.d = d;
    }
    @Override
    public boolean equals(Object o) {
        try {
            Dot obj = (Dot) o;
            return this.x == obj.x && this.y == obj.y;
        } catch(Exception e) {
            return false;
        }
    }
    @Override
    public int hashCode() {
        double prime = 31, result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + d;
        return (int) result;
    }
}
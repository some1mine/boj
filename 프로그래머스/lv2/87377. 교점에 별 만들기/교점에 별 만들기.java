import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<Point> set = new HashSet<>();
        for(int i = 0 ; i < line.length ; i++) {
            for(int j = i + 1 ; j < line.length ; j++) {
                if(line[i][0] * line[j][1] - line[i][1] * line[j][0] != 0) {
                    double x = (double) ((long) line[i][1] * (long) line[j][2] - (long) line[i][2] * (long) line[j][1])
                        / ((long) line[i][0] * (long) line[j][1] - (long) line[i][1] * (long) line[j][0]);
                    double y = (double) ((long) line[i][2] * (long) line[j][0] - (long) line[i][0] * (long) line[j][2])
                        / ((long) line[i][0] * (long) line[j][1] - (long) line[i][1] * (long) line[j][0]);
                    if(x % 1 == 0 && y % 1 == 0) {
                        Point point = new Point((long) x, (long) y);
                        set.add(point);
                    }
                }
            }
        }
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        List<String> list = new ArrayList<>();
        for(Point p : set) {
            if(p.x < minX) minX = p.x;
            if(p.y < minY) minY = p.y;
            if(p.x > maxX) maxX = p.x;
            if(p.y > maxY) maxY = p.y;
        }
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] arr = new char[height][width];
        for(char[] row : arr) Arrays.fill(row, '.');
        for(Point p : set) {
            int x = (int) (p.x - minX), y = (int) (maxY - p.y);
            arr[y][x] = '*';
        }
        answer = new String[arr.length];
        for(int i = 0 ; i < answer.length ; i++) answer[i] = new String(arr[i]);
        return answer;
    }
}

class Point {
    long x, y;
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point == false) return false;
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x + y * (x - y)); 
    }
}
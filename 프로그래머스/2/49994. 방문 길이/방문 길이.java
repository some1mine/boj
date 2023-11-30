import java.util.*;

class Solution {
    Set<Direction> set = new HashSet<>(); Direction move;
    public int solution(String dirs) {
        int answer = 0;
        int[] cur = new int[2];
        for(char c : dirs.toCharArray()) {
            switch(c) {
                case 'U':
                    if(cur[0] == 5) break;
                    move = new Direction(cur[0], ++cur[0], cur[1], cur[1]);
                    if(!set.contains(move)) answer++;
                    set.add(move);
                    break;
                case 'D':
                    if(cur[0] == -5) break;
                    move = new Direction(cur[0], --cur[0], cur[1], cur[1]);
                    if(!set.contains(move)) answer++;
                    set.add(move);
                    break;
                case 'R':
                    if(cur[1] == 5) break;
                    move = new Direction(cur[0], cur[0], cur[1], ++cur[1]);
                    if(!set.contains(move)) answer++;
                    set.add(move);
                    break;
                case 'L':
                    if(cur[1] == -5) break;
                    move = new Direction(cur[0], cur[0], cur[1], --cur[1]);
                    if(!set.contains(move)) answer++;
                    set.add(move);
                    break;
            }
        }
        return answer;
    }
}

class Direction {
    public int fromY, fromX, toY, toX;
    Set<Integer> ySet = new HashSet<>(), xSet = new HashSet<>();
    public Direction(int fromY, int toY, int fromX, int toX) {
        this.fromY = fromY; ySet.add(fromY);
        this.toY = toY; ySet.add(toY);
        this.fromX = fromX; xSet.add(fromX);
        this.toX = toX; xSet.add(toX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction obj = (Direction) o;
        return this.ySet.containsAll(obj.ySet) && this.xSet.containsAll(obj.xSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ySet, this.xSet);
    }
}
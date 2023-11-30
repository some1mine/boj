import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<Direction> set = new HashSet<>(); Direction move = null; int answer = 0, y = 0, x = 0;
        for(char c : dirs.toCharArray()) {
            if(c == 'U' && y != 5) move = new Direction(Set.of(y, ++y), Set.of(x));
            if(c == 'R' && x != 5) move = new Direction(Set.of(y), Set.of(x, ++x)); 
            if(c == 'D' && y != -5) move = new Direction(Set.of(y, --y), Set.of(x));
            if(c == 'L' && x != -5) move = new Direction(Set.of(y), Set.of(x, --x));  
            if(!set.contains(move)) {
                set.add(move); answer++;
            }
        }
        return answer;
    }
}

class Direction {
    Set<Integer> ySet, xSet;
    public Direction(Set<Integer> ySet, Set<Integer> xSet) {
        this.ySet = ySet; this.xSet = xSet;
    }
    @Override
    public boolean equals(Object o) {
        Direction obj = (Direction) o;
        return this.ySet.containsAll(obj.ySet) && this.xSet.containsAll(obj.xSet);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.ySet, this.xSet);
    }
}
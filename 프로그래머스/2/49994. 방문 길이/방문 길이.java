import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0, y = 0, x = 0;
        Map move = null; Set set = new HashSet<>();
        for(char c : dirs.toCharArray()) {
            if(c == 'U' && y != 5) move = Map.of(Set.of(y, ++y), Set.of(x));
            if(c == 'D' && y != -5) move = Map.of(Set.of(y, --y), Set.of(x));
            if(c == 'R' && x != 5) move = Map.of(Set.of(y), Set.of(x, ++x));
            if(c == 'L' && x != -5) move = Map.of(Set.of(y), Set.of(x, --x));
            if(set.contains(move)) continue;
            set.add(move); answer++;
        }
        return answer;
    }
}
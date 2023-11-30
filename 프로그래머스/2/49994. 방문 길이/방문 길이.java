import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0, y = 0, x = 0;
        Set set = new HashSet<>();
        for(char c : dirs.toCharArray()) {
            Map move =
                    c == 'U' && y !=  5 ? move = Map.of(Set.of(y, ++y), Set.of(x)) :
                    c == 'R' && x !=  5 ? move = Map.of(Set.of(y), Set.of(x, ++x)) :
                    c == 'D' && y != -5 ? move = Map.of(Set.of(y, --y), Set.of(x)) :
                    c == 'L' && x != -5 ? move = Map.of(Set.of(y), Set.of(x, --x)) :
                    null;
            if(move == null || set.contains(move)) continue;
            set.add(move); answer++;
        }
        return answer;
    }
}
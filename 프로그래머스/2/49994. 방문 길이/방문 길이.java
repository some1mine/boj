import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0, y = 0, x = 0;
        Set set = new HashSet<>();
        for(char c : dirs.toCharArray()) {
            Map move =
                    c == 'U' && y <  5 ? move = Map.of(Set.of(y, ++y), Set.of(x)) : // 상
                    c == 'D' && y > -5 ? move = Map.of(Set.of(y, --y), Set.of(x)) : // 하
                    c == 'L' && x > -5 ? move = Map.of(Set.of(y), Set.of(x, --x)) : // 좌
                    c == 'R' && x <  5 ? move = Map.of(Set.of(y), Set.of(x, ++x)) : // 우
                    null;
            if(move == null || set.contains(move)) continue;
            set.add(move); answer++;
        }
        return answer;
    }
}
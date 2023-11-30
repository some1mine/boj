import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0, x = 0, y = 0;
        Set set = new HashSet<>();
        for(char c : dirs.toCharArray()) {
            Map move =
                    (c == 'U' && y <  5) ? Map.of(Set.of(x), Set.of(y, ++y)) : // 상
                    (c == 'D' && y > -5) ? Map.of(Set.of(x), Set.of(y, --y)) : // 하
                    (c == 'L' && x > -5) ? Map.of(Set.of(x, --x), Set.of(y)) : // 좌
                    (c == 'R' && x <  5) ? Map.of(Set.of(x, ++x), Set.of(y)) : // 우
                    null;
            if(move == null || set.contains(move)) continue;
            answer++; set.add(move);
        }
        return answer;
    }
}

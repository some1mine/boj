import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<Map<Set<Integer>, Set<Integer>>> set = new HashSet<>(); 
        Map<Set<Integer>, Set<Integer>> move = null; 
        int answer = 0, y = 0, x = 0;
        for(char c : dirs.toCharArray()) {
            if(c == 'U' && y != 5) move = Map.of(Set.of(y, ++y), Set.of(x));
            if(c == 'R' && x != 5) move = Map.of(Set.of(y), Set.of(x, ++x)); 
            if(c == 'D' && y != -5) move = Map.of(Set.of(y, --y), Set.of(x));
            if(c == 'L' && x != -5) move = Map.of(Set.of(y), Set.of(x, --x));  
            if(!set.contains(move)) {
                set.add(move); answer++; 
            }
        }
        return answer;
    }
}
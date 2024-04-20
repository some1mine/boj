import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2]; int min = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < gems.length ; i++) {
            if(!map.containsKey(gems[i])) answer = new int[] {min + 1, i + 1};
            map.put(gems[i], i);
            if(gems[min].equals(gems[i])) {
                min = map.values().stream().mapToInt(n -> n).min().orElse(0);
                if(answer[1] - answer[0] > i - min) answer = new int[] {min + 1, i + 1};
            }
        }
        return answer;
    }
}
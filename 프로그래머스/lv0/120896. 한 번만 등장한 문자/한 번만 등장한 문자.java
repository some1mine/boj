import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String str : s.split("")) map.put(str, map.getOrDefault(str, 0) + 1);
        for(Map.Entry<String, Integer> iter : map.entrySet()) {
            if(iter.getValue() == 1) {
                answer += iter.getKey();
            }
        }
        answer = Arrays.stream(answer.split("")).sorted().collect(Collectors.joining());
        return answer;
    }
}
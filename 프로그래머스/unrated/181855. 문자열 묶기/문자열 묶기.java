import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(String str : strArr) map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        answer = map.values().stream().mapToInt(i -> i).max().getAsInt();
        return answer;
    }
}
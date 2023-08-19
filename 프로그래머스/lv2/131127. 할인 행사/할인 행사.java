import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < want.length ; i++) map.put(want[i], number[i]);
        for(int i = 0 ; i <= discount.length - 10 ; i++) {
            if(possible(discount, new HashMap(map), i)) answer++;
        }
        return answer;
    }
    public boolean possible(String[] discount, Map<String, Integer> map, int idx) {
        for(int i = idx ; i < idx + 10 ; i++) {
            int amount = map.getOrDefault(discount[i], 0);
            if(amount > 0) map.put(discount[i], amount - 1);
        }
        return map.values().stream().mapToInt(i -> i).sum() == 0;
    }
}
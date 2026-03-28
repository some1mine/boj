import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health, time = 0;
        Map<Integer, Integer> attackMap = new HashMap<>();
        for(int[] attack : attacks) attackMap.put(attack[0], attack[1]);
        int end = attackMap.keySet().stream().mapToInt(i -> i).max().getAsInt();
        for(int i = 0 ; i <= end ; i++) {
            if(attackMap.containsKey(i)) {
                time = 0; answer -= attackMap.get(i);
            } else {
                answer = Math.min(health, answer + bandage[1]); time++;
                if(time == bandage[0]) {
                    answer = Math.min(health, answer + bandage[2]); time = 0;
                }
            }
            if(answer <= 0) return -1;
        }
        return answer;
    }
}
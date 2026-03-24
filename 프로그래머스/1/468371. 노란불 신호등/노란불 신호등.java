import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int[] states = new int[signals.length];
        for(int i = 0 ; i < 11_000_000 ; i++) {
            for(int j = 0 ; j < signals.length ; j++) {
                int target = i % (signals[j][0] + signals[j][1] + signals[j][2]);
                states[j] = target <= signals[j][0] + signals[j][1] && target > signals[j][0] ? 1 : 0;
            }
            if(Arrays.stream(states).sum() == signals.length) return i;
        }
        return -1;
    }
}
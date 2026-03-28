import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0; Arrays.sort(weights);
        for(int i = 0 ; i < weights.length - 1 ; i++) {
            int w1 = weights[i];
            for(int j = i + 1 ; j < weights.length ; j++) {
                int w2 = weights[j];
                if(w2 <= w1 * 2 && isBalanced(w1, w2)) answer++;
                if(w2 > w1 * 2) break;
            }
        }
        return answer;
    }
    public boolean isBalanced(int a, int b) {
        return a == b || a * 2 == b || a * 3 == b * 2 || a * 4 == b * 3 ;
    }
}
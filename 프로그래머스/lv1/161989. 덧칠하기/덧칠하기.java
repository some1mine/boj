import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] painted = new boolean[n];
        Arrays.fill(painted, true);
        for(int i : section) painted[i - 1] = false;
        for(int i = 0 ; i < n ; i++) {
            if(!painted[i]) {
                answer++;
                for(int j = i ; j < Math.min(i + m, n) ; j++) painted[j] = true;
            }
        }
        return answer;
    }
}
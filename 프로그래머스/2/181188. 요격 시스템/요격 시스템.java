import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int answer = 1, end = targets[0][1];
        for(int[] target : targets) {
            if(end <= target[0])  {
                answer++; end = target[1];
            }
        }
        return answer;
    }
}
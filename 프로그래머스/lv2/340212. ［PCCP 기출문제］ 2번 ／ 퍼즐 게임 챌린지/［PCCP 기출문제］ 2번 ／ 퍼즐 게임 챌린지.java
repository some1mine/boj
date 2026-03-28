import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = Arrays.stream(diffs).max().getAsInt(), min = 1;
        if(count(diffs, times, 0) <= limit) return 1;
        while(min <= max) {
            int level = (max + min) / 2;
            if(count(diffs, times, level) <= limit) max = level - 1;
            if(count(diffs, times, level) > limit) min = level + 1;
        }
        return min;
    }
    long count(int[] diffs, int[] times, int level) {
        long answer = diffs[0] > level ? (diffs[0] - level) * (times[0] + 1) : times[0];
        for(int i = 1 ; i < diffs.length ; i++) {
            answer += times[i];
            if(diffs[i] > level) answer += (diffs[i] - level) * (times[i] + times[i - 1]);
        }
        return answer;
    }
}
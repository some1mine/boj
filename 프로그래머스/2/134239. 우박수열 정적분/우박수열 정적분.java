import java.util.*;

class Solution {
    public List<Integer> list = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        int count = 0, n = k; list.add(k);
        double[] answer = new double[ranges.length];
        while(n > 1) {
            n = n % 2 == 0 ? n >> 1 : n * 3 + 1;
            list.add(n); count++;
        }
        for(int i = 0 ; i < ranges.length ; i++) answer[i] = getIntegral(ranges[i][0], count + ranges[i][1]);
        return answer;
    }
    public double getIntegral(int start, int end) {
        if(start > end) return -1.0;
        double answer = 0;
        for(int i = start ; i < end ; i++) {
            int min = Math.min(list.get(i), list.get(i + 1)), max = Math.max(list.get(i), list.get(i + 1));
            answer += min + (max - min) * 0.5;
        }
        return answer;
    }
}
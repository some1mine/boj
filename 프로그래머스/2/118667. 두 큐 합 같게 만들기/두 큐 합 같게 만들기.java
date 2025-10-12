import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0, start = 0, len = queue1.length, end = len;
        long sum1 = Arrays.stream(queue1).sum(), sum2 = Arrays.stream(queue2).sum(), sum = sum1 + sum2;
        if(sum % 2 == 1) return -1;
        
        int[] mergedArr = new int[len * 2];
        for(int i = 0 ; i < len ; i++) mergedArr[i] = queue1[i];
        for(int i = 0 ; i < len ; i++) mergedArr[len + i] = queue2[i];
        
        while(sum1 != sum / 2) {
            if(answer > len * 3 - 3) return -1;
            if(sum1 < sum / 2) sum1 += mergedArr[end++];
            else if(sum1 > sum / 2) sum1 -= mergedArr[start++];
            answer++; start %= len * 2; end %= len * 2;
        }
        return answer;
    }
}
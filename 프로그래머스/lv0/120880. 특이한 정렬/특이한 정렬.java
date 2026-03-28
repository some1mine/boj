import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length]; int cnt = 0; Arrays.sort(numlist);
        while(cnt < numlist.length) {
            int numIdx = 0;
            for(int i = 0 ; i < numlist.length ; i++) {
                if(Math.abs(numlist[i] - n) <= Math.abs(numlist[numIdx] - n)) numIdx = i;
            }
            answer[cnt++] = numlist[numIdx];
            numlist[numIdx] = Integer.MAX_VALUE;
        }
        return answer;
    }
}
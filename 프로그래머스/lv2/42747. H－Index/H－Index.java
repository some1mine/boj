import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = citations[citations.length - 1] ; i >= 0 ; i--) {
            final int h = i;
            long count = Arrays.stream(citations).filter(num -> num >= h).count();
            if(count >= h) {
                answer = h; break;
            }
        }
        return answer;
    }
}
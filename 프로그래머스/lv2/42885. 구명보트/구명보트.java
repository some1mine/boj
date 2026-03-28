import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int minIdx = 0;
        Arrays.sort(people);
        for(int i = people.length - 1 ; i >= minIdx ; i -= 1) {
            if(people[i] + people[minIdx] <= limit) {
                answer += 1;
                minIdx += 1;
            } else {
                answer += 1;
            }
        }
        return answer;
    }
}
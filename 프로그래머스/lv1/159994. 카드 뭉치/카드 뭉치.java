import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int oneIdx = 0, twoIdx = 0;
        for(int i = 0 ; i < goal.length ; i++) {
            if(oneIdx < cards1.length && goal[i].equals(cards1[oneIdx])) oneIdx++;
            else if(twoIdx < cards2.length && goal[i].equals(cards2[twoIdx])) twoIdx++;
            else return "No";
        }
        return answer;
    }
}
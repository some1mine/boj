import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        List<String> list = Arrays.asList(s2);
        for(String s : s1) {
            if(list.contains(s)) answer++;
        }
        return answer;
    }
}
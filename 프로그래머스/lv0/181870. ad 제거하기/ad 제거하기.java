import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        List<String> list = new ArrayList<String>();
        for(String s : strArr) {
            if(s.contains("ad")) continue;
            list.add(s);
        }
        answer = list.toArray(String[]::new);
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        for(int i = 1 ; i < s.length() ; i++) {
            List<String> tokens = new ArrayList<>();
            String last = "";
            int count = 0;
            for(int j = 0 ; j < s.length() ; j += i) {
                int endIdx = j + i;
                if(endIdx > s.length()) endIdx = s.length();
                
                String tmp = s.substring(j, endIdx);
                if(tmp.equals(last)) {
                    count++;
                } else {
                    if(count > 1) tokens.add(Integer.toString(count));
                    tokens.add(last);
                    last = tmp;
                    count = 1;
                }
            }
            if(count > 1) tokens.add(Integer.toString(count));
            tokens.add(last);
            int tmp = 0;
            
            for(String str : tokens) tmp += str.length();
            answer = Math.min(answer, tmp);
        }
        return answer;
    }
}
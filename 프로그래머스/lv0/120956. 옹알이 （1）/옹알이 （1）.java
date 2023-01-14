import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = {"aya", "ye", "woo", "ma"};
        List<String> list = new ArrayList<>();
        for(String s1 : can) {
            list.add(s1);
            for(String s2 : can) {
                if(!s1.equals(s2)) list.add(s1 + s2);
                for(String s3 : can) {
                    if(!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3)) list.add(s1 + s2 + s3);
                    for(String s4 : can) {
                        if(!s1.equals(s2) && !s1.equals(s3) && !s1.equals(s4) && !s2.equals(s3)
                          && !s2.equals(s4) && !s3.equals(s4)) list.add(s1 + s2 + s3 + s4);
                    }
                }
            }
        }
        for(String s : babbling) {
            if(list.contains(s)) answer++;
        }
        return answer;
    }
}
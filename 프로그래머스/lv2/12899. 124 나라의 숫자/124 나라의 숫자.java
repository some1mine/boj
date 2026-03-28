import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = ""; 
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            if(n % 3 == 0) {
                list.add(0, 4); n--;
            }
            else list.add(0, n % 3);
            n /= 3;
        }
        for(Integer i : list) answer += i;
        return answer;
    }
}
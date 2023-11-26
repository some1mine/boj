import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = ""; int ord = 0, num = 0;
        while(answer.length() < t) {
            String number = Integer.toString(num++, n).toUpperCase();
            for(int i = 0 ; i < number.length() && answer.length() < t; i++, ord++) {
                if(ord % m == p - 1) answer += number.charAt(i);
            }
        }
        return answer;
    }
}
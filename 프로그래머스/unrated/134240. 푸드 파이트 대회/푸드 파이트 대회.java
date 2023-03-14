import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 0 ; i < food.length ; i++) {
            if(food[i] / 2 > 0) {
                for(int j = 0 ; j < food[i] / 2 ; j++) {
                    answer += i;
                }
            }
        }
        String tmp = new StringBuffer(answer).reverse().toString();
        answer += 0; answer += tmp;
        return answer;
    }
}
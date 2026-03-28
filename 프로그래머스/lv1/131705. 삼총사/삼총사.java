import java.util.*;

class Solution {
    public int answer = 0;
    public int solution(int[] number) {
        recursive(number, 0, 0, 0);
        return answer;
    }
    public void recursive(int[] number, int cnt, int sum, int ord) {
        if(cnt == 3) {
            if(sum == 0) answer++; return;
        }
        for(int i = ord ; i < number.length ; i++) recursive(number, cnt + 1, sum + number[i], i + 1);
    }
}
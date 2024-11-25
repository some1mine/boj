import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0, target = Math.min(wallet[0], wallet[1]), maxi = Math.max(wallet[0], wallet[1]);
        while(Math.min(bill[0], bill[1]) > target || Math.max(bill[0], bill[1]) > maxi) {
            if(bill[0] > bill[1]) bill[0] >>= 1;
            else bill[1] >>= 1;
            answer++;
        }
        return answer;
    }
}
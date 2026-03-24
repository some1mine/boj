import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0; boolean[] choosed = new boolean[cards.length];
        int[] pair = new int[cards.length], cost = new int[cards.length]; Arrays.fill(cost, 2);
        for(int i = 0 ; i < cards.length ; i++) {
            if(pair[i] > 0) continue;  
            for(int j = i + 1 ; j < cards.length ; j++) {
                if(cards[i] + cards[j] == cards.length + 1) {
                    pair[i] = j; pair[j] = i;
                }
            }
        }
        for(int i = 0 ; i < cards.length / 3 ; i++) {
            if(i < pair[i]) cost[pair[i]]--;
            else cost[i]--;
        }
        while(coin >= 0) {
            int reachIdx = Math.min(cards.length / 3 + 2 * (answer + 1) - 1, cards.length - 1), best = -1;
            for(int i = 0 ; i < reachIdx + 1 ; i++) {
                if(choosed[i] || i < pair[i]) continue;
                if(best == -1 || cost[i] < cost[best]) best = i;
            }
            if(best == -1 || coin - cost[best] < 0) break;
            coin -= cost[best]; choosed[best] = true; answer++;
        }
        return Math.min(answer + 1, cards.length / 3 + 1);
    }
}
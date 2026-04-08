class Solution {
    public long solution(int[][] cost, int[][] hint) {
        long answer = Integer.MAX_VALUE;
        for(int mask = 0 ; mask < 1 << (cost.length - 1) ; mask++) {
            int[] h = new int[cost.length]; int total = 0;
            for(int i = 0 ; i < cost.length ; i++) {
                if((mask & (1 << i)) > 0) {
                    total += hint[i][0];
                    for(int k = 1 ; k < hint[i].length ; k++) {
                        h[hint[i][k] - 1]++;
                    }
                }
            }
            for(int i = 0 ; i < cost.length ; i++) {
                int best = Integer.MAX_VALUE;
                for(int k = 0 ; k < Math.min(h[i] + 1, cost.length) ; k++) best = Math.min(best, cost[i][k]);
                total += best;
            }
            answer = Math.min(answer, total);
        }
        return answer;
    }
}
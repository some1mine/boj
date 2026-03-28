class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; int[] servers = new int[24];
        for(int i = 0 ; i < 24 ; i++) {
            if(players[i] >= (servers[i] + 1) * m) {
                answer += players[i] / m - servers[i];
                for(int j = 1 ; j < k && i + j < 24 ; j++) servers[i + j] += players[i] / m - servers[i];
            }
        }
        return answer;
    }
}
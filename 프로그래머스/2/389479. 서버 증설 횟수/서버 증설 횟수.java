class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; int[] servers = new int[24];
        for(int i = 0 ; i < players.length ; i++) {
            if(players[i] >= (servers[i] + 1) * m) {
                int addnum = players[i] / m - servers[i]; answer += addnum;
                for(int j = 0 ; j < k ; j++) {
                    if(i + j == players.length) break;
                    servers[i + j] += addnum;
                }
            }
        }
        return answer;
    }
}
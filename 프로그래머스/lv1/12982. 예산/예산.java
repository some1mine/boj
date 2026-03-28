class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int tmp = 0;
        int max = d.length;
        
        for(int i = 0 ; i < d.length ; i += 1) tmp += d[i];
        for(int i = 0 ; i < d.length - 1 ; i += 1) {
            for(int j = i + 1 ; j < d.length ; j += 1) {
                if(d[i] < d[j]) {
                    int tmp1 = d[i]; d[i] = d[j]; d[j] = tmp1;
                }
            }
        }
        
        for(int i = 0 ; i < d.length ; i += 1) {
            if(tmp > budget) {
                tmp -= d[i]; max -= 1;
            }
        }
        
        answer = max;
        
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        int facto = 1;
        for(int i = 1; i <= n ; i++) {
            facto *= i;
            if(facto > n) {
                answer = i - 1; break;
            } else if(facto == n) {
                answer = i; break;
            }
        }
        return answer;
    }
}
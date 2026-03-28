class Solution {
    public int solution(int n) {
        int answer = getLCM(n) / 6;
        return answer;
    }
    public int getLCM(int n) {
        int lcm = n * 6;
        for(int i = n ; i < n * 6 ; i++) {
            if(i % n == 0 && i % 6 == 0) {
                lcm = i; break;
            }
        }
        return lcm;
    }
}
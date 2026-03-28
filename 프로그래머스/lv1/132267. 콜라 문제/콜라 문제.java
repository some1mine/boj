class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true) {
            n -= a;
            if(n < 0) break;
            n += b;
            answer += b;
        }
        return answer;
    }
}
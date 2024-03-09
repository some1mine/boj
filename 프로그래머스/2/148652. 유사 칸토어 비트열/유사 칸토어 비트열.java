class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i = l - 1 ; i < r ; i++) answer = isOne(i, n) ? answer + 1 : answer;
        return answer;
    }
    public boolean isOne(long l, int n) {
        for(int i = 0 ; i < n && l > 1 ; i++, l /= 5) {
            if(l % 5 == 2) return false;
        }
        return true;
    }
}
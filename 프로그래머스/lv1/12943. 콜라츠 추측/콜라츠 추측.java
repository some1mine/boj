class Solution {
    public int solution(long num) {
        return recursive(num, 0);
    }
    public int recursive(long num, int cnt) {
        if(cnt > 500) return -1;
        if(num == 1) return cnt;
        if(num % 2 == 0) return recursive(num / 2, cnt + 1);
        return recursive(num * 3 + 1, cnt + 1);
    }
}
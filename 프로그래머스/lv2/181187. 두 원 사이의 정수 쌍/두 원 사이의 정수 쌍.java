class Solution {
    public long solution(long r1, long r2) {
        long answer = 0;
        for(long i = 1 ; i <= r2 ; i++)  answer += (long) Math.floor(Math.sqrt(r2 * r2 - i * i)) - (long) Math.ceil(Math.sqrt(r1 * r1 - i * i)) + 1;
        return answer * 4;
    }
}
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0 ; i <= d ; i += k) answer += count(i, k, d);
        return answer;
    }
    public long count(long n, long k, long d) {
        long distance = (long) Math.sqrt(d * d - n * n) / k;
        return distance + 1;
    }
}
class Solution {
    public int[] solution(long s, long e) {
        int begin = (int) s, end = (int) e; 
        int[] answer = new int[end - begin + 1];
        if (begin == 1) answer[0] = 0;
        for (int i = 0 ; i < answer.length ; i++) answer[i] = getGcd(begin + i);
        return answer;
    }
    public int getGcd(long n) {
        long answer = 1;
        for (long i = 2 ; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                answer = Math.max(answer, i);
                if (n / i <= 10_000_000) answer = Math.max(answer, n / i);
            }
        }
        return (int) (n == 1 ? 0 : answer);
    }
}
class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        String num = Integer.toString(n, k);
        answer = getPrimes(num);
        return answer;
    }
    public int getPrimes(String num) {
        int answer = 0;
        for(String s : num.split("0")) {
            if(!s.equals("") && isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }
    public boolean isPrime(long num) {
        if(num == 1) return false;
        if(num == 2) return true;
        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
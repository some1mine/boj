import java.util.*;

class Solution {
    public int solution(int n, int k) {
        return getPrimes(Integer.toString(n, k));
    }
    public int getPrimes(String num) {
        return (int) Arrays.stream(num.split("0")).filter(s -> !s.equals("") && isPrime(Long.parseLong(s))).count();
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
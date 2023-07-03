import java.util.*;

class Solution {
    public boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2 ; i * i <= n ; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public void getPrimes(int num, int[] numbers, boolean[] used, Set<Integer> primes) {
        if(isPrime(num)) primes.add(num);
        
        for(int i = 0 ; i < numbers.length ; i++) {
            if(used[i]) continue;
            int nextNum = num * 10 + numbers[i];
            used[i] = true;
            getPrimes(nextNum, numbers, used, primes);
            used[i] = false;
        }
    }
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        int[] nums = numbers.chars().map(c -> c - '0').toArray();
        getPrimes(0, nums, new boolean[nums.length], primes);
        return primes.size();
    }
}
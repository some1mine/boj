import java.util.*;
import java.io.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int[] arr = revise(a, b);
        Set<Integer> set = getDivisors(arr[1]);
        set.remove(2); set.remove(5);
        if(set.size() == 0) answer = 1;
        else answer = 2;
        return answer;
    }
    public int[] revise(int a, int b) {
        for(int i = 1 ; i <= a ; i++) {
            if(a % i == 0 && b % i == 0) {
                a /= i; b /= i;
            }
        }
        return new int[]{a, b};
    }
    public Set<Integer> getDivisors(int n) {
        Set<Integer> list = new HashSet<>();
        for(int i = 2 ; i <= n ; i++) {
            if(n % i == 0 && isPrime(i)) list.add(i);
        }
        return list;
    }
    public boolean isPrime(int n) {
        if(n == 2) return true;
        for(int i = 2 ; i < n ; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
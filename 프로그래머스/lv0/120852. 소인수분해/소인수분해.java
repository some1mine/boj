import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = getFactors(n);
        return answer;
    }
    public int[] getFactors(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2 ; i <= n ; i++) {
            if(isPrime(i) && n % i == 0) {
                list.add(i);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) ret[i] = list.get(i);
        return ret;
    }
    public boolean isPrime(int i) {
        if(i == 2) return true;
        for(int k = 2 ; k < i ; k++) {
            if(i % k == 0) return false;
        }
        return true;
    }
}
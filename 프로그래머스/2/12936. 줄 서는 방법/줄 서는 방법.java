import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n]; int count = 0;
        long[] factorials = factorials(n);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) list.add(i);
        
        while(count++ < n){
            long quotient = k / factorials[n - count], remainder = k % factorials[n - count];
            int idx = (int) (quotient);
            if(remainder == 0) {
                answer[count - 1] = list.get(idx);
                list.remove(idx);
                for(int i = 1 ; i < list.size() ; i++) answer[count - 1 + i] = list.get(list.size() - i);
                break;
            }
            answer[count - 1] = list.get(idx + 1);
            list.remove(idx + 1);
            k = remainder;
        }
        return answer;
    }
    public long[] factorials(int n) {
        long[] answer = new long[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) answer[i] = factorial(i);
        return answer;
    }
    public long factorial(int n){
        if(n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }
}
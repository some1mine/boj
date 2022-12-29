import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) {
            if(n % i == 0) list.add(i);
        }
        for(int i : list) {
            for(int j : list) {
                if(i * j == n) answer++;
            }
        }
        return answer;
    }
}
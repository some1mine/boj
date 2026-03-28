import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] list = new int[n+1];
        list[0] = 0;
        list[1] = 0;
        
        for(int i = 2 ; i <= n ; i++){
            list[i] = 1;
        }
        for(int i = 2 ; (i*i) <= n ; i++) {
            if(list[i] == 1) {
                for(int j = i*i ; j <= n ; j += i) {
                    list[j] = 0;
                }
            }
        }
        
        for(int i = 0 ; i <= n ; i++) {
            if(list[i] == 1) {
                answer++;
            }
        }
        
        
        return answer;
    }
}
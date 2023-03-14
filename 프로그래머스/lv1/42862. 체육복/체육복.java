import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] students = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) students[i]++;
        for(int i : lost) students[i]--;
        for(int i : reserve) students[i]++;
        
        for(int i = 1 ; i <= n ; i++) {
            if(students[i] == 0 && students[i - 1] > 1) {
                students[i] = 1; students[i - 1] -= 1;
            } else if(students[i] == 0 && i < n && students[i + 1] > 1) {
                students[i] = 1; students[i + 1] -= 1;
            } else if(students[i] == 0) {
                answer--;
            }
        }
        return answer;
    }
}
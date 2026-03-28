import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for(int i = 0 ; i < park.length ; i++) {
            for(int j = 0 ; j < park[0].length ; j++) {
                for(int mat : mats) {
                    if(possible(i, j, mat, park)) answer = Math.max(mat, answer);
                }
            }
        }    
        return answer;
    }
    public boolean possible(int y, int x, int len, String[][] park) {
        for(int i = x ; i < x + len ; i++) {
            for(int j = y ; j < y + len ; j++) {
                if(i >= park[0].length || j >= park.length || !park[j][i].equals("-1")) return false;
            }
        }
        return true;
    }
}
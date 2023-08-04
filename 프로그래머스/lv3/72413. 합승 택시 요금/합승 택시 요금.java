import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n][n];
        
        for(int[] arr : map) Arrays.fill(arr, 1_000_000);
        for(int i = 0 ; i < n ; i++) map[i][i] = 0;
        
        for(int[] fare : fares) {
            if(map[fare[0] - 1][fare[1] - 1] > fare[2]) map[fare[0] - 1][fare[1] - 1] = fare[2];            
            if(map[fare[1] - 1][fare[0] - 1] > fare[2]) map[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        
        for(int k = 0 ; k < n ; k++) {
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
            }
        }
        
        for(int i = 0 ; i < n ; i++) answer = Math.min(answer, map[s - 1][i] + map[i][a - 1] + map[i][b - 1]);
        
        return answer;
    }
}
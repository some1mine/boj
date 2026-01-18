import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = alp, targetCop = cop;
        for(int[] p : problems) {
            targetAlp = targetAlp < p[0] ? p[0] : targetAlp;
            targetCop = targetCop < p[1] ? p[1] : targetCop;
        }
        
        int[][] targets = Arrays.copyOf(problems, problems.length + 2);
        targets[targets.length - 1] = new int[]{0,0,1,0,1};
        targets[targets.length - 2] = new int[]{0,0,0,1,1};
        
        int[][] dp = new int[targetAlp + 2][targetCop + 2];
        for(int[] d : dp) Arrays.fill(d, 9999999); dp[alp][cop] = 0;
        
        for(int i = alp ; i < targetAlp + 1 ; i++) {
            for(int j = cop ; j < targetCop + 1 ; j++) {
                for(int[] p : targets) {
                    if(i >= p[0] && j >= p[1]) {
                        int nextAlp = Math.min(targetAlp, i + p[2]), nextCop = Math.min(targetCop, j + p[3]);
                            dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + p[4]);
                    }
                }
            }
        }
        return dp[targetAlp][targetCop];
    }
}
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
        
        int[][] dp = new int[targetAlp + 1][targetCop + 1];
        for(int[] d : dp) Arrays.fill(d, 9999999); dp[alp][cop] = 0;
        
        for(int a = alp ; a < targetAlp + 1 ; a++) {
            for(int c = cop ; c < targetCop + 1 ; c++) {
                for(int[] p : targets) {
                    if(a >= p[0] && c >= p[1]) {
                        int nextAlp = Math.min(targetAlp, a + p[2]), nextCop = Math.min(targetCop, c + p[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[a][c] + p[4]);
                    }
                }
            }
        }
        return dp[targetAlp][targetCop];
    }
}
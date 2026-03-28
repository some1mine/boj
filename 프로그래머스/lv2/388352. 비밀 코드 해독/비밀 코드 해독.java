import java.util.*;

class Solution {
    public int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        combination(n, q, ans, 0, new ArrayList<>()); return answer;
    }
    void combination(int n, int[][] q, int[] ans, int start, List<Integer> list) {
        if(list.size() == 5) {
            if(possible(list, q, ans)) answer++; return;
        }
        for(int i = start ; i < n ; i++) {
            list.add(i + 1); combination(n, q, ans, i + 1, list); list.remove(list.size() - 1);
        }
    }
    boolean possible(List<Integer> caseList, int[][] q, int[] ans) {
        for(int i = 0 ; i < ans.length ; i++) {
            int judge = 0;
            for(int j : q[i]) judge += caseList.contains(j) ? 1 : 0;
            if(judge != ans[i]) return false;
        }
        return true;
    }
}
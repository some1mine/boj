import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Set<Integer> nums = new HashSet<>(); int[] answer = new int[4]; 
        int[][] conn = new int[1_000_001][2];
        for(int[] edge : edges) {
            conn[edge[0]][1]++; conn[edge[1]][0]++; nums.add(edge[0]); nums.add(edge[1]);
        }
        for(int i : nums) {
            if(conn[i][0] == 0 && conn[i][1] >= 2) answer[0] = i;
            if(conn[i][0] >= 1 && conn[i][1] == 0) answer[2]++;
            if(conn[i][0] > 1 && conn[i][1] > 1) answer[3]++;
        }
        answer[1] = conn[answer[0]][1] - answer[2] - answer[3];
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n][n];
        for(int[] result : results) {
            graph[result[0] - 1][result[1] - 1] = 1; graph[result[1] - 1][result[0] - 1] = -1;
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                for(int k = 0 ; k < n ; k++) {
                    if(graph[i][j] == 1 && graph[j][k] == 1) {
                        graph[i][k] = 1; graph[k][i] = -1;
                    }
                    if(graph[i][j] == -1 && graph[j][k] == -1) {
                        graph[i][k] = -1; graph[k][i] = 1;
                    }
                }
            }
        }
        return (int) Arrays.stream(graph).filter(arr -> Arrays.stream(arr).filter(i -> i == 0).count() == 1).count();
    }
}
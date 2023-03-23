import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Arrays.sort(costs, (x, y) -> {
            if(x[2] == y[2] && x[1] == y[1]) return x[0] - y[0];
            if(x[2] == y[2]) return x[1] - y[1];
            return x[2] - y[2];
        });
        List<Integer> list = new ArrayList<>();
        int min = costs[0][2];
        
        while(true) {
            for(int i = 0 ; i < costs.length ; i++) {
                if(costs[i][2] == min && (!visited[costs[i][0]] || !visited[costs[i][1]])) {
                    visited[costs[i][0]] = true; visited[costs[i][1]] = true; answer += min;
                    list.add(costs[i][0]); list.add(costs[i][1]);
                }
            }
            min = Integer.MAX_VALUE;
            for(int i = 0 ; i < costs.length ; i++) {
                if(list.contains(costs[i][0]) && !visited[costs[i][1]] && costs[i][2] < min) {
                    min = costs[i][2];
                }
                if(list.contains(costs[i][1]) && !visited[costs[i][0]] && costs[i][2] < min) {
                    min = costs[i][2];
                }
            }
            if(allVisited(visited)) break;
        }
        return answer;
    }
    public boolean allVisited(boolean[] visited) {
        for(boolean b : visited) {
            if(!b) return false;
        }
        return true;
    }
}
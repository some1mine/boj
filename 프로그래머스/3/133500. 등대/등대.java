import java.util.*;
import java.util.stream.*;

import static java.lang.System.*;

class Solution {
    List<Integer>[] graph;
    public int solution(int n, int[][] lighthouse) {
        graph = IntStream.rangeClosed(0, n).mapToObj(i->new ArrayList()).toArray(List[]::new);
        for(int[] edge:lighthouse) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[][] res = new int[n+1][2];
        Deque<Integer> stk = new ArrayDeque();
        stk.offerLast(1);
        while(!stk.isEmpty()){
            int node = stk.pollLast();
            if(node > 0){
                visited[node] = true;
                stk.offerLast(-node);
                for(int child:graph[node]){
                    if(!visited[child]){
                        stk.offerLast(child);
                    }
                }
            } else { 
                node = -node;
                for(int child:graph[node]){
                    if(res[child][0] > 0){
                        res[node][0] += Math.min(res[child][0], res[child][1]);
                        res[node][1] += res[child][0];
                    }
                }
                res[node][0]++;
            }
        }

        return Math.min(res[1][0], res[1][1]);
    }
}
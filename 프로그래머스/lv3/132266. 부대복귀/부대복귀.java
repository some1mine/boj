import java.util.*;

class Solution {
    public List<List<Integer>> list;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());
        for(int[] road : roads) {
            list.get(road[0]).add(road[1]); list.get(road[1]).add(road[0]);
        }
        for(int i = 0 ; i < sources.length ; i++) answer[i] = get(sources[i], destination, n);
        return answer;
    }
    public int get(int source, int destination, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, 0});
        visited[source] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == destination) return cur[1];
            List<Integer> road = list.get(cur[0]);
            if(road.isEmpty()) return -1;
            for(int i : road) {
                if(i == destination) return cur[1] + 1;
                if(!visited[i]) {
                    visited[cur[0]] = true;
                    queue.offer(new int[]{i, cur[1] + 1});
                }
            }
        }
        return -1;
    }
}
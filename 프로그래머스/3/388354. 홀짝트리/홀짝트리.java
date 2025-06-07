import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        Map<Integer, Set<Integer>> trees = new HashMap<>();
        for(int node : nodes) trees.put(node, new HashSet<>());
        for(int[] edge: edges) {
            trees.get(edge[0]).add(edge[1]); trees.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int node : nodes) {
            if(visited.contains(node)) continue;
            Queue<Integer> queue = new LinkedList<>(); queue.offer(node); visited.add(node);
            int right = 0, reverse = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll(); 
                if(cur % 2 == trees.get(cur).size() % 2) right++;
                else reverse++;
                for(int next : trees.get(cur)) {
                    if(visited.contains(next)) continue;
                    queue.offer(next); visited.add(next);
                }
            }
            if(right == 1) answer[0]++;
            if(reverse == 1) answer[1]++;
        }
        return answer;
    }
}
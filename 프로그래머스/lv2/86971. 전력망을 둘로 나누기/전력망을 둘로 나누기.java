import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) list[i] = new ArrayList<>();
        for(int[] wire : wires) {
            list[wire[0]].add(wire[1]); list[wire[1]].add(wire[0]);
        }
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 0 ; j < list[i].size() ; j++) {
                int node = list[i].get(0);
                list[i].remove(Integer.valueOf(node));
                list[node].remove(Integer.valueOf(i));
                int left = getNum(list, i, n), right = getNum(list, node, n);
                answer = Math.min(Math.abs(left - right), answer);
                list[i].add(node);
                list[node].add(i);
            }
        }
        return answer;
    }
    public int getNum(List<Integer>[] list, int node, int n) {
        int answer = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : list[cur]) {
                if(!visited[i]) {
                    visited[i] = true; answer++; queue.add(i);
                }
            }
        }
        return answer;
    }
}
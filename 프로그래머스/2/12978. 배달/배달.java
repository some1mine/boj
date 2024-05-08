import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] road, int k) {
        List<List<Road>> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());
        for(int[] r : road) {
            list.get(r[0]).add(new Road(r[1], r[2])); list.get(r[1]).add(new Road(r[0], r[2]));
        }
        return (int) Arrays.stream(dijkstra(list, k)).filter(i -> i <= k).count();
    }
    public int[] dijkstra(List<List<Road>> list, int k) {
        int[] distances = new int[list.size()]; 
        Arrays.fill(distances, 100_000_000); distances[1] = 0;
        PriorityQueue<Road> queue = new PriorityQueue<>();
        queue.offer(new Road(1, 0));
        while(!queue.isEmpty()) {
            Road cur = queue.poll();
            for(Road r : list.get(cur.dest)) {
                if(distances[r.dest] > distances[cur.dest] + r.cost) {
                    distances[r.dest] = distances[cur.dest] + r.cost;
                    queue.offer(new Road(r.dest, distances[r.dest]));
                }
            }
        }
        return distances;
    }
}

class Road implements Comparable<Road> {
    public int dest, cost;
    public Road(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}
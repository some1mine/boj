import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        int[] nmx = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Road>> list = new ArrayList<>();
        for(int i = 0 ; i < nmx[0] ; i++) list.add(new ArrayList<>());
        for(int i = 0 ; i < nmx[1] ; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(arr[0] - 1).add(new Road(arr[1] - 1, arr[2]));
        }
        for(int i = 0 ; i < nmx[0] ; i++) answer = Math.max(answer, dijkstra(list, nmx[0], i, nmx[2] - 1) + dijkstra(list, nmx[0], nmx[2] - 1, i));
        System.out.print(answer);
    }
    public static int dijkstra(List<List<Road>> list, int n, int from, int to) {
        boolean[] visited = new boolean[n];
        int[] costs = new int[n];
        Arrays.fill(costs, 100_000_000);
        costs[from] = 0;
        PriorityQueue<Road> queue = new PriorityQueue<>();
        queue.offer(new Road(from, 0));
        while(!queue.isEmpty()) {
            Road cur = queue.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;
            for(Road r : list.get(cur.idx)) {
                if(costs[r.idx] > costs[cur.idx] + r.cost) {
                    costs[r.idx] = costs[cur.idx] + r.cost;
                    queue.offer(new Road(r.idx, costs[r.idx]));
                }
            }
        }
        return costs[to];
    }
}

class Road implements Comparable<Road> {
    public int idx, cost;
    public Road(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}
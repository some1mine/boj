import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()), m = Integer.parseInt(reader.readLine());
        List<Set<Load>> loads = new ArrayList<>();
        long[] costs = new long[n + 1]; Arrays.fill(costs, Long.MAX_VALUE - 100_000);
        for (int i = 0; i < n + 1; i++) loads.add(new HashSet<>());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            loads.get(Integer.parseInt(st.nextToken())).add(new Load(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        System.out.print(dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), loads, costs));
    }
    private static long dijkstra(int from, int to, List<Set<Load>> loads, long[] costs) {
        PriorityQueue<Load> queue = new PriorityQueue<>();
        queue.add(new Load(from, 0)); costs[from] = 0;

        while (!queue.isEmpty()) {
            Load cur = queue.poll();

            if (cur.cost > costs[cur.idx]) continue;

            for (Load next : loads.get(cur.idx)) {
                if (costs[next.idx] > cur.cost + next.cost) {
                    costs[next.idx] = cur.cost + next.cost; queue.add(new Load(next.idx, costs[next.idx]));
                }
            }
        }

        return costs[to];
    }
}

class Load implements Comparable<Load> {
    public int idx;
    public long cost;

    public Load(int idx, long cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Load o) {
        if (this.cost == o.cost) return this.idx - o.idx;
        return (int) (this.cost - o.cost);
    }
}

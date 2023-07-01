import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        for(int caseNum = 1 ; ; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            if(n == 0) break;
            
            int[][] arr = new int[n][n];
            for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            builder.append("Problem ").append(caseNum).append(": ").append(dijkstra(arr, n)).append("\n");
        }
        System.out.print(builder);
    }
    public static int dijkstra(int[][] arr, int n) {
        int[][] dist = new int[n][n];
        for(int i = 0 ; i < n ; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<Rupee> queue = new PriorityQueue<>();
        queue.offer(new Rupee(0, 0, arr[0][0]));
        
        while(!queue.isEmpty()) {
            Rupee cur = queue.poll();
            if(cur.cost > dist[cur.y][cur.x]) continue;
            
            for(int i = 0 ; i < 4 ; i++) {
                int dy = cur.y + dirY[i], dx = cur.x + dirX[i];
                if(dy < 0 || dy >= n || dx < 0 || dx >= n) continue;
                if(dist[dy][dx] > cur.cost + arr[dy][dx]) {
                    dist[dy][dx] = cur.cost + arr[dy][dx];
                    queue.offer(new Rupee(dx, dy, dist[dy][dx]));
                }
            }
        }
        return dist[n - 1][n - 1];
    }
}

class Rupee implements Comparable<Rupee> {
    public int x, y, cost;
    public Rupee(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    @Override
    public int compareTo(Rupee o) {
        return this.cost - o.cost;
    }
}
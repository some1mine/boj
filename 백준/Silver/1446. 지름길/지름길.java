import java.util.*;

public class Main {
    public static int[] distances;
    public static List<Node>[] graph;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), d = scanner.nextInt();
        distances = new int[d + 1];
        for(int i = 0 ; i <= d ; i++) distances[i] = i;
        graph = new ArrayList[d + 1];
        for(int i = 0 ; i <= d ; i++) graph[i] = new ArrayList<Node>();
        for(int i = 0 ; i < n ; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            if(a <= d) graph[a].add(new Node(b, c));
        }
        System.out.println(solution(d));
    }
    public static int solution(int d) {
        for(int i = 0 ; i <= d ; i++) {
            if(i > 0) distances[i] = Math.min(distances[i], distances[i - 1] + 1);
            if(!graph[i].isEmpty()) {
                for(Node node : graph[i]) {
                    if(node.idx > d) continue;
                    distances[node.idx] = Math.min(distances[node.idx], distances[i] + node.distance);
                }
            }
        }
        return distances[d];
    }
    public static class Node {
        int idx, distance;
        Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }
}
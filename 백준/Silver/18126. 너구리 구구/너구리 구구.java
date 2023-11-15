import java.util.*;
 
public class Main {
    public static long[] consequent;
    public static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); 
        consequent = new long[n + 1]; visited = new boolean[n + 1];
 
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());
        while(--n > 0) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(arr[0]).add(new int[]{arr[1], arr[2]}); list.get(arr[1]).add(new int[]{arr[0], arr[2]});
        }
        System.out.print(getFurthest(list));
    }
    public static long getFurthest(List<List<int[]>> list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); visited[1] = true; consequent[1] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int[] arr : list.get(cur)) {
                if(!visited[arr[0]]) {
                    visited[arr[0]] = true; queue.add(arr[0]); consequent[arr[0]] = consequent[cur] + arr[1];
                }
            }
        }
        return Arrays.stream(consequent).max().getAsLong();
    }
}
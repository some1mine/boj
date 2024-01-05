import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] ab = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long answer = -1;
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{ab[0], 0});
        while(!queue.isEmpty()){
            long[] cur = queue.poll();
            if(cur[0] * 2 <= ab[1]) queue.offer(new long[]{cur[0] * 2, cur[1] + 1});
            if(cur[0] * 10 + 1 <= ab[1]) queue.offer(new long[]{cur[0] * 10 + 1, cur[1] + 1});
            if(cur[0] == ab[1]) answer = cur[1] + 1;
        }
        System.out.print(answer);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(); scanner.nextLine();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedList<Integer> list = new LinkedList();
        for (int i = 1; i <= n; i++) list.addLast(i);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if(numbers[i] != list.getFirst()){
                int halfIdx = list.size() / 2;
                if(list.indexOf(numbers[i]) > halfIdx) {
                    while(numbers[i] != list.getFirst()) {
                        list.addFirst(list.pollLast()); cnt++;
                    }
                } else {
                    while(numbers[i] != list.getFirst()) {
                        list.addLast(list.pollFirst()); cnt++;
                    }
                }
            }
            list.pollFirst();
        }
        System.out.println(cnt);
    }
}

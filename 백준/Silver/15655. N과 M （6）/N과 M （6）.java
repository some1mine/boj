import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nm = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        combination(nm[1], 0, arr, new ArrayList());
    }
    public static void combination(int m, int start, int[] arr, List<Integer> list) {
        if(list.size() == m) {
            for(int i : list) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for(int i = start ; i < arr.length ; i++) {
            list.add(arr[i]);
            combination(m, i + 1, arr, list);
            list.remove(Integer.valueOf(arr[i]));
        }
    }
}
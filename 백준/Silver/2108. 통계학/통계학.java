import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(scanner.nextLine());
        Arrays.sort(arr);
        System.out.println(Math.round(Arrays.stream(arr).sum() * 1.0 / arr.length));
        System.out.println(arr[arr.length / 2]);
        List<Long> list = new ArrayList<>();
        for(int i = 0 ; i < 8001 ; i++) list.add(0L);
        for(int i = 0 ; i < arr.length ; i++) list.set(arr[i] + 4000, list.get(arr[i] + 4000) + 1);
        long count = list.stream().mapToLong(i -> i).max().getAsLong();
        if(Collections.frequency(list, count) == 1) System.out.println(list.indexOf(count) - 4000);
        else {
            list.remove(Long.valueOf(count));
            System.out.println(list.indexOf(count) - 3999);
        }
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}

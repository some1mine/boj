import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        list.add(64);
        while(true) {
            if(list.stream().mapToInt(i -> i).sum() == x) break;
            else if(list.stream().mapToInt(i -> i).sum() > x) {
                int bar = list.stream().mapToInt(i -> i).min().getAsInt();
                list.remove(Integer.valueOf(bar));
                bar >>= 1;
                list.add(bar);
                if(list.stream().mapToInt(i -> i).sum() < x) list.add(bar);
            }
        }
        System.out.print(list.size());
    }
}
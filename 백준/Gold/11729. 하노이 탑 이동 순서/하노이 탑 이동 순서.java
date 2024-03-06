import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        recursive(n, 1, 2, 3);
        System.out.print(count + "\n" + sb.toString());
    }
    public static void recursive(int n, int from, int via, int to) {
        if(n == 0) return;
        
        recursive(n - 1, from, to, via);
        sb.append(from + " " + to + "\n"); count++;
        recursive(n - 1, via, from, to);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] dots = new int[n][2];
        for(int i = 0 ; i < n ; i++) dots[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(dots, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int i = 0 ; i < n ; i++) System.out.println(dots[i][0] + " " + dots[i][1]);
    }
}
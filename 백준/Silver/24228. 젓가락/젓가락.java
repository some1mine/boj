import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
        long n = Long.parseLong(st.nextToken()), r = Long.parseLong(st.nextToken());
        System.out.print(n + r * 2 - 1);
    }
}
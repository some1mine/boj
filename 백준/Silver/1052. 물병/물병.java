import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] nk = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long answer = 0;
        while(count(nk[0]) > nk[1]) {
            nk[0]++; answer++;
        }
        System.out.print(answer);
    }
    public static long count(long num) {
        long count = 0;
        while(num > 0) {
            count += num % 2; num /= 2;
        }
        return count;
    }
}
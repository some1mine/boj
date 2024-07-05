import java.util.*;

public class Main {
    public static Map<Long, Long> map = new HashMap<>();
    public static int mod = 1_000_000_007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        map.put(0L, 0L); map.put(1L, 1L); map.put(2L, 1L);
        long n = Long.parseLong(scanner.nextLine());
        System.out.print(get(n));
    }
    public static long get(long n) {
        if(map.containsKey(n)) return map.get(n);
        if(n % 2 == 0){
            long n1 = n / 2, n2 = (n / 2) - 1,
                num = (get(n1) % mod * (get(n1) % mod + (2 * get(n2) % mod) % mod) % mod) % mod;
            map.put(n, num);
            return num;
        }
        long n1 = (n - 1) / 2, n2 = (n + 1) / 2,
            num = ((get(n1) * get(n1)) % mod + (get(n2) * get(n2)) % mod ) % mod;
        map.put(n, num);
        return num;
    }
}
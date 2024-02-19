import java.io.*;
import java.util.*;
import java.math.*;
/**
nCm
*/
public class Main {
    public static Map<Integer, BigInteger> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());
        initializeMap();
        while(T-- > 0) {
            int[] ab = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(count(ab[0], ab[1]).toString()).append("\n");
        }
        reader.close(); System.out.print(sb);
    }
    public static void initializeMap() {
        BigInteger n = new BigInteger("1"); map.put(0, n);
        for(int i = 1 ; i < 30 ; i++) map.put(i, n = map.get(i - 1).multiply(new BigInteger(i + "")));
    }
    public static BigInteger count(int min, int max) {
        return factorial(max).divide(factorial(min)).divide(factorial(max - min));
    }
    public static BigInteger factorial(int n) {
        return map.get(n);
    }
}
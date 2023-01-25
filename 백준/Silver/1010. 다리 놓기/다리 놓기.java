import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i < n ; i++) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(solution(nm[0], nm[1])).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(int n, int m) {
        int max = Math.max(n, m), min = Math.min(n, m);
        return (factorial(max).divide(factorial(max - min)).divide(factorial(min))).intValue();
    }
    private static BigInteger factorial(int n) {
        BigInteger answer = BigInteger.ONE;
        for(int i = 1; i <= n ; i++) answer = answer.multiply(BigInteger.valueOf(i));
        return answer;
    }
}
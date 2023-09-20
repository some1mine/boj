import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        int input = 0; BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            input = Integer.parseInt(br.readLine());
            if(input == -1) break;
            int people = getPeople(input);
            if(people == -1) sb.append(input).append(" coconuts, no solution\n");
            else sb.append(input).append(" coconuts, ").append(people).append(" people and 1 monkey\n");
        }
        System.out.print(sb);
    }
    public static int getPeople(int n) {
        int answer = -1;
        for(int i = 1 ; i <= n ; i++) { 
            if(isPossible(n, i)) answer = i;
        }
        return answer;
    }
    public static boolean isPossible(int n, int i) {
        for(int k = 0 ; k < i ; k++) {
            if(n % i != 1) return false;
            n--; n = n - n / i;
            if(n == 0) return true;
        }
        return true;
    }
}
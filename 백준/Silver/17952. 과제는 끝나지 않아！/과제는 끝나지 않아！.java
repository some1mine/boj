import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()), startTime = 0, answer = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type != 0) {
                int score = Integer.parseInt(st.nextToken()), time = Integer.parseInt(st.nextToken());
                stack.push(new int[]{score, time});
            }
            if(!stack.isEmpty()) {
                stack.peek()[1]--;
                if(stack.peek()[1] == 0) answer += stack.pop()[0];
            }
        }
        System.out.print(answer);
    }
}
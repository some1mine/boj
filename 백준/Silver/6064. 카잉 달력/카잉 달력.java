import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i < n ; i++) {
            int[] mnxy = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(solution(mnxy)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(int[] mnxy) {
        int answer = -1;

        while (mnxy[3] <= mnxy[0] * mnxy[1]) {
            if ((mnxy[3] - mnxy[2]) % mnxy[0] == 0) {
                return mnxy[3];
            }
            mnxy[3] += mnxy[1];
        }
        return answer;
    }
}
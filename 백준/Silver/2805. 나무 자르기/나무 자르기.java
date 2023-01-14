import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int len = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int[] having = new int[len];
        int cnt = 0;
        int maxNum = 0;
        int minNum = Integer.MAX_VALUE;
        for(String s : input) {
            having[cnt++] = Integer.parseInt(s);
            maxNum = Math.max(having[cnt - 1], maxNum);
            minNum = Math.min(having[cnt - 1], minNum);
        }

        int low = 0;
        int high = maxNum;
        while(low <= high) {
            int mid = (low + high) / 2;
            long calc = 0;
            for(int i = 0 ; i < len ; i++) {
                if(having[i]>mid)
                    calc += (having[i] - mid);
            }
            if(calc < target) {
                high = mid - 1;
            } else if(calc > target) {
                low = mid + 1;
            } else {
                high = mid;
                break;
            }
        }

        System.out.println(high);
    }
}
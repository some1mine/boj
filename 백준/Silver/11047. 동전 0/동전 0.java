import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nk = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] arr = new Integer[nk[0]];
        int answer = 0;
        for(int i = 0 ; i < nk[0] ; i++) arr[i] = Integer.parseInt(scanner.nextLine());
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i : arr) {
            if(nk[1] >= i) {
                answer += nk[1] / i; nk[1] %= i;
            }
        }
        System.out.print(answer);
    }
}
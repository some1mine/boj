import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); int answer = -1;
        int[] nm = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = i + 1 ; j < arr.length ; j++) {
                for(int k = j + 1 ; k < arr.length ; k++) {
                    int tmp = Math.max(answer, arr[i] + arr[j] + arr[k]);
                    answer = tmp <= nm[1] ? Math.max(answer, tmp) : answer;
                }
            }
        }
        System.out.print(answer);
    }
}
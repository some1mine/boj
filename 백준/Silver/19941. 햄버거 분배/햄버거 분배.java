import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nk = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[] input = scanner.nextLine().toCharArray();
        int answer = 0;
        if(input[0] == 'H') {
            for(int i = 0 ; i < nk[0] ; i++) {
                if (input[i] == 'P' && isPossible(nk, input, i, true)) answer++;
            }
        } else {
            for(int i = nk[0] - 1 ; i >= 0 ; i--) {
                if(input[i] == 'P' && isPossible(nk, input, i, false)) answer++;
            }
        }
        System.out.print(answer);
    }

    private static boolean isPossible(int[] nk, char[] input, int i, boolean mode) {
        if (mode) {
            for(int j = Math.max(0, i - nk[1]); j <= Math.min(nk[0] - 1, i + nk[1]) ; j++) {
                if (input[j] == 'H') {
                    input[j] = 'X'; return true;
                }
            }
        } else {
            for(int j = Math.min(nk[0] - 1, i + nk[1]) ; j >= Math.max(0, i - nk[1]) ; j--) {
                if(input[j] == 'H') {
                    input[j] = 'X'; return true;
                }
            }
        }
        return false;
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nk = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[] input = scanner.nextLine().toCharArray();
        int answer = 0; boolean mode = true;
        if(input[0] == 'H') {
            for(int i = 0 ; i < nk[0] ; i++) {
                if(input[i] == 'P' && mode) {
                    for(int j = Math.max(0, i - nk[1]) ; j <= Math.min(nk[0] - 1, i + nk[1]) ; j++) {
                        if(input[j] == 'H') {
                            input[j] = 'X'; answer++; break;
                        }
                    }
                }
            }
        } else {
            for(int i = nk[0] - 1 ; i >= 0 ; i--) {
                if(input[i] == 'P') {
                    for(int j = Math.min(nk[0] - 1, i + nk[1]) ; j >= Math.max(0, i - nk[1]) ; j--) {
                        if(input[j] == 'H') {
                            input[j] = 'X'; answer++; break;
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
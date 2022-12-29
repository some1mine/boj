import java.util.*;
import java.io.*;
 
public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[3];
        solution(arr, answer);
        for(int i : answer) System.out.println(i);
    }
    public static void solution(int[][] arr, int[] answer) {
        if(check(arr)) {
            if(arr[0][0] == -1) answer[0]++;
            if(arr[0][0] == 0) answer[1]++;
            if(arr[0][0] == 1) answer[2]++;
            return;
        }
        else {
            int[][] newArr = new int[arr.length / 3][arr.length / 3];
            int n = arr.length, n3 = arr.length / 3;
            for(int i = 0 ; i < n3 ; i++) {
                for(int j = 0 ; j < n3 ; j++) newArr[i][j] = arr[i][j];
            }
            solution(newArr, answer);
            for(int i = 0 ; i < n3 ; i++) {
                for(int j = n3, k = 0 ; k < n3 ; j++, k++) {
                    newArr[i][k] = arr[i][j];
                }
            }
            solution(newArr, answer);
            for(int i = 0 ; i < n3 ; i++) {
                for(int j = n3 * 2, k = 0 ; k < n3 ; j++, k++) {
                    newArr[i][k] = arr[i][j];
                }
            }
            solution(newArr, answer);
            for(int i = n3, j = 0 ; j < n3 ; i++, j++) {
                for(int k = 0 ; k < n3 ; k++) {
                    newArr[j][k] = arr[i][k];
                }
            }
            solution(newArr, answer);
            for(int i = n3, j = 0 ; j < n3 ; i++, j++) {
                for(int k = n3, l = 0 ; l < n3 ; k++, l++) {
                    newArr[j][l] = arr[i][k];
                }
            }
            solution(newArr, answer);
            for(int i = n3, j = 0 ; j < n3 ; i++, j++) {
                for(int k = n3 * 2, l = 0 ; l < n3 ; k++, l++) {
                    newArr[j][l] = arr[i][k];
                }
            }
            solution(newArr, answer);
            for(int i = n3 * 2, j = 0 ; j < n3 ; i++, j++) {
                for(int k = 0 ; k < n3 ; k++) {
                    newArr[j][k] = arr[i][k];
                }
            }
            solution(newArr, answer);
            for(int i = n3 * 2, j = 0 ; j < n3 ; i++, j++) {
                for(int k = n3, l = 0 ; l < n3 ; k++, l++) {
                    newArr[j][l] = arr[i][k];
                }
            }
            solution(newArr, answer);
            for(int i = n3 * 2, j = 0 ; j < n3 ; i++, j++) {
                for(int k = n3 * 2, l = 0 ;l < n3 ; k++, l++) {
                    newArr[j][l] = arr[i][k];
                }
            }
            solution(newArr, answer);
        }
    }
    public static boolean check(int[][] arr) {
        for(int i = 0 ; i < arr.length - 1; i++) {
            for(int j = 0 ; j < arr.length - 1 ; j++) {
                if(arr[i][j] == arr[i + 1][j] 
                   && arr[i][j] == arr[i][j + 1] 
                   && arr[i][j] == arr[i + 1][j + 1]) continue;
                return false;
            }
        }
        return true;
    }
}
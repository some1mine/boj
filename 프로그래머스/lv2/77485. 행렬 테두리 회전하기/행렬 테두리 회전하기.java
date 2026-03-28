import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int[] answer = new int[queries.length];
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++) arr[i][j] = i * columns + j + 1;
        }
        for(int i = 0 ; i < queries.length ; i++) answer[i] = getMin(arr, queries[i]);
        return answer;
    }
    public int getMin(int[][] arr, int[] query) {
        int min = Integer.MAX_VALUE, tmp1 = arr[query[0]][query[1] - 1];
        for(int i = query[1] - 1 ; i < query[3] - 1 ; i++) {
            min = Math.min(min, arr[query[0] - 1][i]);
            int tmp2 = arr[query[0] - 1][i];
            arr[query[0] - 1][i] = tmp1; tmp1 = tmp2;
        }
        for(int i = query[0] - 1 ; i < query[2] - 1 ; i++) {
            min = Math.min(min, arr[i][query[3] - 1]);
            int tmp2 = arr[i][query[3] - 1]; 
            arr[i][query[3] - 1] = tmp1; tmp1 = tmp2;
        }
        for(int i = query[3] - 1 ; i > query[1] - 1 ; i--) {
            min = Math.min(min, arr[query[2] - 1][i]);
            int tmp2 = arr[query[2] - 1][i]; 
            arr[query[2] - 1][i] = tmp1; tmp1 = tmp2;
        }
        for(int i = query[2] - 1 ; i >= query[0] - 1 ; i--) {
            min = Math.min(min, arr[i][query[1] - 1]);
            int tmp2 = arr[i][query[1] - 1];
            arr[i][query[1] - 1] = tmp1; tmp1 = tmp2;
        }
        return min;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0 ; i < answer.length ; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int ord = commands[i][2] - 1;
            int[] arr = Arrays.copyOfRange(array, from ,to);
            Arrays.sort(arr);
            answer[i] = arr[ord];
        }
        return answer;
    }
}
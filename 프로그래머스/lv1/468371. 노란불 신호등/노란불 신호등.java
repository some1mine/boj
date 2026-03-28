import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int[] states = new int[signals.length];
        for(int i = 0 ; i <= getTerm(signals) ; i++) {
            for(int j = 0 ; j < signals.length ; j++) {
                int target = i % (signals[j][0] + signals[j][1] + signals[j][2]);
                states[j] = signals[j][0] < target && target <= signals[j][0] + signals[j][1] ? 1 : 0;
            }
            if(Arrays.stream(states).sum() == signals.length) return i;
        }
        return -1;
    }
    public int getTerm(int[][] arr) {
        int answer = 1, comm = 1;
        for(int i = 1 ; i <= Arrays.stream(arr[0]).sum() ; i++) {
            int tmp = 0;
            for(int j = 0 ; j < arr.length ; j++) {
                if(Arrays.stream(arr[j]).sum() % i == 0) tmp++;
            }
            if(tmp == arr.length) comm = i;
        }
        for(int i = 0 ; i < arr.length ; i++) answer *= Arrays.stream(arr[i]).sum() / comm;
        return answer * comm;
    }
}
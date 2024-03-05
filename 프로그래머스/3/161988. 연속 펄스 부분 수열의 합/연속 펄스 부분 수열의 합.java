import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int[] arr = Arrays.copyOf(sequence, sequence.length);
        for(int i = 0 ; i < arr.length ; i++) {
            if(i % 2 == 0) arr[i] *= -1; 
            else sequence[i] *= -1;
        }
        return Math.max(getMax(sequence), getMax(arr));
    }
    public long getMax(int[] arr) {
        long[] dp = new long[arr.length]; dp[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++) dp[i] = Math.max(0, dp[i - 1]) + arr[i];
        return Arrays.stream(dp).max().getAsLong();
    }
}
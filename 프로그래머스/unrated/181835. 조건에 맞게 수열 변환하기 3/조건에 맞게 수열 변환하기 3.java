import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = Arrays.stream(arr).map(x -> k % 2 == 0 ? x + k : x * k).toArray();
        return answer;
    }
}
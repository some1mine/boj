import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1); int idx = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : arr) {
            if(idx == k) return answer;
            if(!set.contains(i)) {
                set.add(i); answer[idx++] = i;
            }
        }
        return answer;
    }
}
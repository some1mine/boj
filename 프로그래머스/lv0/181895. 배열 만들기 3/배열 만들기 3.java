import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int[] ar : intervals) {
            for(int i = ar[0] ; i <= ar[1] ; i++) list.add(arr[i]);
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
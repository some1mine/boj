import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int num : arr) {
            for(int i = 0 ; i < num ; i++) list.add(num);
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
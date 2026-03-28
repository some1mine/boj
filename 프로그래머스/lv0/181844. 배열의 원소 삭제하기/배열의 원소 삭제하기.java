import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int i : arr) list.add(i);
        for(int i : delete_list) {
            if(list.contains(i)) list.remove(Integer.valueOf(i));
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
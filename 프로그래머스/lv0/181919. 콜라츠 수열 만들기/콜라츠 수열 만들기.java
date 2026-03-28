import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        while(n != 1) {
            list.add(n);
            if(n % 2 == 0) n >>= 1;
            else n = n * 3 + 1;
        }
        list.add(1);
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
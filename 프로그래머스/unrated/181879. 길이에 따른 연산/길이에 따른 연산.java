import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = num_list.length <= 10 ? Arrays.stream(num_list).reduce((x, y) -> x * y).getAsInt()
            : Arrays.stream(num_list).reduce((x, y) -> x + y).getAsInt();
        return answer;
    }
}
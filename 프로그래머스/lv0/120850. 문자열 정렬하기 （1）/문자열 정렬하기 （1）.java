import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = my_string.chars().filter(c -> (c >= '0' && c <= '9')).map(c -> c - 48).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
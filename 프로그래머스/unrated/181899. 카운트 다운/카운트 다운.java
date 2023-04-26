import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int start, int end) {
        int[] answer = IntStream.rangeClosed(end, start).map(i -> -i).sorted().map(i -> -i).toArray();
        return answer;
    }
}
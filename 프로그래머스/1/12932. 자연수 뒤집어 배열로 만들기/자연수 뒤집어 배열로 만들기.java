import java.util.*;

class Solution {
    public int[] solution(long n) {
        return Arrays.stream(new StringBuilder(Long.toString(n)).reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
    }
}
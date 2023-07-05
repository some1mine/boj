import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).sorted((s1, s2) -> {
            int origin = Integer.parseInt(s1 + s2);
            int reversed = Integer.parseInt(s2 + s1);
            return reversed - origin;
        }).collect(Collectors.joining("")).replaceAll("^0+", "0");
    }
}
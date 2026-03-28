import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(long n) {
        return Long.parseLong(Arrays.stream(Long.toString(n).split("")).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining()));
    }
}
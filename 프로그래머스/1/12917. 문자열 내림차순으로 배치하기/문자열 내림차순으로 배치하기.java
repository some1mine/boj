import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.joining());
    }
}
import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        before = Stream.of(before.split("")).sorted().collect(Collectors.joining());
        after = Stream.of(after.split("")).sorted().collect(Collectors.joining());
        if(before.equals(after)) answer = 1;
        return answer;
    }
}
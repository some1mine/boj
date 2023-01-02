import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();
        answer = Stream.of(answer.split("")).sorted().collect(Collectors.joining());
 
        return answer;
    }
}
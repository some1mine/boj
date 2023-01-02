import java.util.stream.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2; String tmp = "";
        for(String s : spell) tmp += s;
        for(String s : dic) {
            if(Stream.of(s.split("")).sorted().collect(Collectors.joining())
               .equals(Stream.of(tmp.split("")).sorted().collect(Collectors.joining()))) {
                answer = 1; break;
            }
        }
        return answer;
    }
}
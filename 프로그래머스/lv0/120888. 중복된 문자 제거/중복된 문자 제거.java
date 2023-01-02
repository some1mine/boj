class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(String s : my_string.split("")) {
            if(answer.contains(s)) continue;
            answer += s;
        }
        return answer;
    }
}
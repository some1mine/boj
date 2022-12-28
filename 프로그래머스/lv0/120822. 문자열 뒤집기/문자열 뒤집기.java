class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(String s : my_string.split("")) answer = s + answer;
        return answer;
    }
}
class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char c : my_string.toCharArray()) {
            if(c >= 'a' && c <= 'z') answer += (char)(c + ('A' - 'a'));
            else answer += (char)(c + ('a' - 'A'));
        }
        return answer;
    }
}
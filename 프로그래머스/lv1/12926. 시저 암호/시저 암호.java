class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(c >= 'a' && c <= 'z') answer += (char) ((c - 'a' + n) % 26 + 'a');
            else if(c >= 'A' && c <= 'Z') answer += (char) ((c - 'A' + n) % 26 + 'A');
            else answer += c;
        }
        return answer;
    }
}
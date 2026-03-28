class Solution {
    public String solution(int age) {
        String answer = "";
        for(char c : String.valueOf(age).toCharArray()) {
            answer += (char)(c - '0' + 'a');
        }
        return answer;
    }
}
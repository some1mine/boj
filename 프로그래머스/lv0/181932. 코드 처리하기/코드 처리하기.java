class Solution {
    public String solution(String code) {
        String answer = ""; boolean mode = true;
        for(int i = 0 ; i < code.length() ; i++) {
            if(code.charAt(i) == '1') mode = !mode;
            else if((mode && i % 2 == 0) || (!mode && i % 2 == 1)) answer += code.charAt(i);
        }
        if(answer.isEmpty()) return "EMPTY";
        return answer;
    }
}
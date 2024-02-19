class Solution {
    public String solution(String s) {
        String answer = ""; boolean isEven = true;
        for(String str : s.split("")) {
            if(isEven) answer += str.toUpperCase();
            else answer += str.toLowerCase();
            isEven = str.equals(" ") ? isEven = true : !isEven;
        }
        return answer;
    }
}
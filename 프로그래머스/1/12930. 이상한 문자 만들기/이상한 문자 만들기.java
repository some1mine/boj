class Solution {
    public String solution(String s) {
        String answer = ""; boolean isEven = true;
        for(String str : s.split("")) {
            if(str.equals(" ")) isEven = false;
            if(isEven) answer += str.toUpperCase();
            else answer += str.toLowerCase();
            isEven = !isEven;
        }
        return answer;
    }
}
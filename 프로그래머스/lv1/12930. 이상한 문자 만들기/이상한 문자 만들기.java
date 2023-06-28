class Solution {
    public String solution(String s) {
        String answer = "";
        boolean toUpper = true;
        for(char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                answer += c; toUpper = true;
            } else {
                if(toUpper) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += Character.toLowerCase(c);
                }
                toUpper = !toUpper;
            }
        }
        return answer;
    }
}
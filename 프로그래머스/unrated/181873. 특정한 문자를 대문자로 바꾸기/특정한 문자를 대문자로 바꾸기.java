class Solution {
    public String solution(String my_string, String alp) {
        String answer = my_string.replace(alp, Character.toString(alp.charAt(0) + 'A' - 'a'));
        return answer;
    }
}
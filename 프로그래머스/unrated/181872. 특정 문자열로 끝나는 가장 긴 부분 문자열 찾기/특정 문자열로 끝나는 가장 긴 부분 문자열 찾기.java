class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i = myString.length() ; i > 0 ; i--) {
            if(myString.substring(0, i).endsWith(pat)) return myString.substring(0, i);
        }
        return answer;
    }
}
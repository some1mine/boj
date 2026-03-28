class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i = 0 ; i < myString.length() ; i++) {
            if(myString.charAt(i) == 'A') myString = myString.substring(0, i) + "B" + myString.substring(i + 1);
            else if(myString.charAt(i) == 'B') myString = myString.substring(0, i) + "A" + myString.substring(i + 1);
        }
        answer = myString.contains(pat) ? 1 : 0;
        return answer;
    }
}
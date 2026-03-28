class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = getShape(picture[i / k], k);
        }
        return answer;
    }
    public String getShape(String s, int k) {
        char[] result = new char[s.length() * k];
        for(int i = 0 ; i < result.length ; i++) {
            result[i] = s.charAt(i / k);
        }
        return new String(result);
    }
}
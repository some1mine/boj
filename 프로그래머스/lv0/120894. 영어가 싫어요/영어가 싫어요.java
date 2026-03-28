class Solution {
    public long solution(String numbers) {
        long answer = 0; String tmp = "";
        for(int i = 0 ; i < numbers.length() ; i++) {
            if(numbers.charAt(i) == 'z') {
                tmp += 0; i += 3;
            } else if(numbers.charAt(i) == 'o') {
                tmp += 1; i += 2;
            } else if(numbers.charAt(i) == 't' && numbers.charAt(i + 1) == 'w') {
                tmp += 2; i += 2;
            } else if(numbers.charAt(i) == 't') {
                tmp += 3; i += 4;
            } else if(numbers.charAt(i) == 'f' && numbers.charAt(i + 1) == 'o') {
                tmp += 4; i += 3;
            } else if(numbers.charAt(i) == 'f') {
                tmp += 5; i += 3;
            } else if(numbers.charAt(i) == 's' && numbers.charAt(i + 1) == 'i') {
                tmp += 6; i += 2;
            } else if(numbers.charAt(i) == 's') {
                tmp += 7; i += 4;
            } else if(numbers.charAt(i) == 'e') {
                tmp += 8; i += 4;
            } else {
                tmp += 9; i += 3;
            }
        }
        answer = Long.parseLong(tmp);
        return answer;
    }
}
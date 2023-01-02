class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int num = i ; num <= j ; num++) {
            if(String.valueOf(num).contains(String.valueOf(k))) {
                for(int num2 = 0 ; num2 < String.valueOf(num).length() ; num2++) {
                    if(String.valueOf(num).charAt(num2) - '0' == k) answer++;
                }
            }
        }
        return answer;
    }
}
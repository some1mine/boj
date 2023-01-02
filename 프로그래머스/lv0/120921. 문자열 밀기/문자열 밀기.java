class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        while(!A.equals(B) && answer < A.length()) {
            char tmp = A.charAt(A.length() - 1);
            A = A.substring(0, A.length() - 1);
            A = tmp + A;
            answer++;
        }
        if(answer == A.length()) answer = -1;
        return answer;
    }
}
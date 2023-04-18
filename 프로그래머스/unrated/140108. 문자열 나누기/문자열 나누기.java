class Solution {
    public int solution(String s) {
        int answer = 0;
        int equalCnt = 0, diffCnt = 0;
        char tmp = s.charAt(0);
        
        for(int i = 0 ; i < s.length() ; i++) {
            if(tmp == s.charAt(i)) equalCnt++;
            else diffCnt++;
            
            if(equalCnt == diffCnt && i < s.length() - 1) {
                answer++;tmp = s.charAt(i + 1);
            } else if(i == s.length() - 1) answer++;
        }
        
        return answer;
    }
}
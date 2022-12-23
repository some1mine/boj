class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        int tLen = t.length();
        long pVal = Long.parseLong(p);
        for(int i = 0 ; i < tLen - pLen + 1 ; i++) {
            if(Long.parseLong(t.substring(i, i + pLen)) <= pVal) answer++;
        }
        return answer;
    }
}
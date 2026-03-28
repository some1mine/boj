class Solution {
    public String[] pronounces = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling) {
            if(possible(s)) answer++;
        }
        return answer;
    }
    public boolean possible(String s) {
        String prev = "";
        while(s.length() > 0) {
            String tmp = s;
            for(String str : pronounces) {
                if(s.startsWith(str) && !prev.equals(str)) {
                    s = s.substring(str.length());
                    prev = str;
                    break;
                }
            }
            if(tmp.equals(s)) return false;
        }
        return true;
    }
}
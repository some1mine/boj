class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(String s : rsp.split("")) {
            if(s.equals("0")) answer += 5;
            if(s.equals("2")) answer += 0;
            if(s.equals("5")) answer += 2;
        }
        return answer;
    }
}
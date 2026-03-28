class Solution {
    public int solution(String s) {
        int answer = 0; String[] tmp = s.split(" ");
        for(int i = 0 ; i < tmp.length ; i++) {
            if(tmp[i].equals("Z")) answer -= Integer.parseInt(tmp[i - 1]);
            else answer += Integer.parseInt(tmp[i]);
        }
        return answer;
    }
}
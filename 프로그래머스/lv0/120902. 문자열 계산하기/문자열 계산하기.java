class Solution {
    public int solution(String my_string) {
        int answer = 0; boolean isMinus = false;
        for(String s : my_string.split(" ")) {
            if(s.equals("+")) continue;
            else if(s.equals("-")) isMinus = true;
            else {
                if(isMinus) answer -= Integer.parseInt(s);
                else answer += Integer.parseInt(s);
                isMinus = false;
            }
        }
        return answer;
    }
}
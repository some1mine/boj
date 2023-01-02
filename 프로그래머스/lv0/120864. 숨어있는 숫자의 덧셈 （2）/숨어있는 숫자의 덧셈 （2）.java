class Solution {
    public int solution(String my_string) {
        int answer = 0; boolean flag = false; int startIdx = 0;
        for(int i = 0 ; i < my_string.length() ; i++) {
            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                if(!flag) startIdx = i;
                flag = true;
            } else {
                if(flag) answer += Integer.parseInt(my_string.substring(startIdx, i));
                flag = false;
            }
        }
        if(flag == true) {
            answer += Integer.parseInt(my_string.substring(startIdx, my_string.length()));
        }
        return answer;
    }
}
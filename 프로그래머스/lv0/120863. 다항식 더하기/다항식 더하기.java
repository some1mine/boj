class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0, num = 0;
        for(String s : polynomial.split(" ")) {
            if(s.equals("+")) continue;
            if(s.equals("x")) x++;
            else if(s.endsWith("x")) x += Integer.parseInt(s.substring(0, s.indexOf("x")));
            else num += Integer.parseInt(s);
        }
        if(x == 0) {
            if(num == 0) answer += 0;
            else answer += num;
        } else if(x == 1) {
            if(num == 0) answer += "x";
            else answer = "x" + " + " + num;
        } else {
            if(num == 0) answer = x + "x";
            else answer = x + "x + " + num;
        }
        return answer;
    }
}
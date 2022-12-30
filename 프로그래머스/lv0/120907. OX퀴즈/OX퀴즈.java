class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length]; int cnt = 0;
        for(String str : quiz) {
            int num1 = 0, num2 = 0; boolean flag = false; boolean isMinus = false;
            for(String s : str.split(" ")) {
                if(s.equals("+")) {
                    continue;
                } else if(s.equals("=")) {
                    flag = true; continue;
                } else if(s.equals("-")) {
                    isMinus = true; continue;
                } else if(flag) {
                    num2 = Integer.parseInt(s); break;
                } else if(isMinus) {
                    num1 -= Integer.parseInt(s);
                    isMinus = false;
                } else {
                    num1 += Integer.parseInt(s);
                }
            }
            if(num1 == num2) answer[cnt++] = "O";
            else answer[cnt++] = "X";
        }
        return answer;
    }
}
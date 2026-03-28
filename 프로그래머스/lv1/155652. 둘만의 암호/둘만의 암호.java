class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                for(int i = 0 ; i < index ; i++) {
                    c = (char) (c + 1);
                    if(c > 'z') c = 'a';
                    if(skip.contains(Character.toString(c))) {
                        i--; continue;
                    }
                }
                answer += Character.toString(c);
            }
        }
        return answer;
    }
}
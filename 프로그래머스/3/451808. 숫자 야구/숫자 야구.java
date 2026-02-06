import java.util.*;
import java.util.function.Function;

class Solution {
    public String[] candi = new String[3024]; int idx = 0;
    public int solution(int n, Function<Integer, String> submit) {
        init("", 0); String result = "0S 0B";
        while(candi.length > 1) {
            result = submit.apply(Integer.parseInt(candi[0]));
            candi = filter(candi[0], result.charAt(0) - '0', result.charAt(3) - '0');
        }
        return Integer.parseInt(candi[0]);
    }
    public void init(String num, int depth) {
        if(depth == 4) {
            candi[idx] = num; idx++; return;
        }
        for(int i = 1 ; i < 10 ; i++) {
            if(num.contains(Integer.toString(i))) continue;
            String newNum = num + i; init(newNum, depth + 1);
        }
    }
    public String[] filter(String num, int strike, int ball) {
        return Arrays.stream(candi)
            .filter(c -> match(num.toCharArray(), c.toCharArray(), strike, ball))
            .toArray(String[]::new);
    }
    public boolean match(char[] num, char[] candi, int strike, int ball) {
        int sCnt = 0, bCnt = 0; Set<Character> tmp = Set.of(num[0], num[1], num[2], num[3]);
        for(int i = 0 ; i < 4 ; i++) {
            if(num[i] == candi[i]) sCnt++;
            else if(tmp.contains(candi[i])) bCnt++;
        }
        return sCnt == strike && bCnt == ball;
    }
}
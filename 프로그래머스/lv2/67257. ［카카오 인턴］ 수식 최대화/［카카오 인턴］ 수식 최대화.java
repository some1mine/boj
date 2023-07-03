import java.util.*;

class Solution {
    public String[][] precedences = {"+-*".split(""), "+*-".split(""), "-+*".split("")
        , "-*+".split(""), "*+-".split(""), "*-+".split("")};
    public long calculate(long left, long right, String op) {
        return switch(op) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> 0;
        };
    }
    public long calculate(List<String> tokens, String[] precedence) {
        for(String op : precedence) {
            for(int i = 0 ; i < tokens.size() ; i++) {
                if(tokens.get(i).equals(op)) {
                    long left = Long.parseLong(tokens.get(i - 1));
                    long right = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(left, right, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    public long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while(st.hasMoreTokens()) tokens.add(st.nextToken());
        for(String[] precedence : precedences) answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(tokens), precedence)));
        
        return answer;
    }
}
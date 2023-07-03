import java.util.*;

class Solution {
    public String[][] predences = {"*-+".split(""), "*+-".split(""), "+*-".split(""), "+-*".split(""),
                                  "-*+".split(""), "-+*".split("")};
    public long calculate(long left, long right, String op) {
        return switch(op) {
            case "+" -> left + right;
            case "*" -> left * right;
            case "-" -> left - right;
            default -> 0;
        };
    }
    public long calculate(List<String> expression, String[] predence) {
        for(String op : predence) {
            for(int i = 0 ; i < expression.size() ; i++) {
                if(expression.get(i).equals(op)) {
                    long left = Long.parseLong(expression.get(i - 1));
                    long right = Long.parseLong(expression.get(i + 1));
                    long result = calculate(left, right, op);
                    expression.remove(i - 1);
                    expression.remove(i - 1);
                    expression.remove(i - 1);
                    expression.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(expression.get(0));
    }
    public long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()) list.add(st.nextToken());
        for(String[] predence : predences) 
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(list), predence)));
        return answer;
    }
}
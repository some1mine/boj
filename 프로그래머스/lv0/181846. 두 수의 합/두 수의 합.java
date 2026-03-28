import java.math.*;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        numA = numA.add(numB);
        answer = numA.toString();
        return answer;
    }
}
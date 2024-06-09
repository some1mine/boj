class Solution {
    public int solution(int[] money) {      
        if(money.length == 3) return Math.max(money[2], Math.max(money[0], money[1]));
        
        int[] dp1 = new int[money.length], dp2 = new int[money.length]; 
        dp1[0] = money[0]; dp1[1] = money[1]; dp2[1] = money[1];
        for(int i = 2 ; i < money.length ; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            if(i > 2) {
                dp1[i] = Math.max(dp1[i], dp1[i - 3] + money[i]);
                dp2[i] = Math.max(dp2[i], dp2[i - 3] + money[i]);
            }
        }
        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}
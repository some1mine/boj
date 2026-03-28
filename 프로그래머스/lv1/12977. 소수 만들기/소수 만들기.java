class Solution {
    public int solution(int[] nums) {
        int answer = 0, num1 = 0, num2 = 1, num3 = 2, 
        caseNum = nums.length * (nums.length - 1) * (nums.length - 2) / 6;
        
        while(caseNum > 0) {
            if(isPrime(nums[num1], nums[num2], nums[num3])) answer += 1;
            if(num3 == nums.length - 1) {
                if(num2 == nums.length - 2) {
                    num1 += 1; num2 = num1 + 1; num3 = num2 + 1;
                } else {
                    num2 += 1; num3 = num2 + 1;
                }
            } else num3 += 1;
            caseNum -= 1;
        }
        return answer;
    }
    
    public static boolean isPrime(int a, int b, int c) {
        int x = a + b + c;
        
        for(int i = 2 ; i < (int)Math.sqrt(x) + 1 ; i += 1) {
            if(x % i == 0) return false;
        }
        return true;
    }
}
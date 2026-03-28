class Solution {
    public int solution(int[] arr) {
        int answer = 0; int max = 0; 
        
        for(int i : arr) max = i > max ? i : max;
        
        for(int i = max ; i < Integer.MAX_VALUE ; i += 1) {
            boolean isCommon = true;
            for(int num : arr) {
                if(i % num > 0) {
                    isCommon = false; break;
                }
            }
            if(isCommon) {
                answer = i; break;
            }
        }
        
        return answer;
    }
}
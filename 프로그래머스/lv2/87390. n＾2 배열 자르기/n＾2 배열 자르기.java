class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        long count = 0; int idx = 0;
        for(int num = 1 ; num <= n ; num++) {
            if(count > right) break;
            for(int i = 0 ; i < num ; i++) {
                if(count + num < left) {
                    count += num; break;
                } else if(count > right) break;
                else answer[idx++] = num;
                count++;
            }
            for(int i = num + 1 ; i <= n ; i++) {
                if(count + n - num < left) {
                    count += n - num; break;
                }else if(count > right) break;
                else answer[idx++] = num;
                count++;
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        if(n <= cores.length) return n;
        
        int min = 1, max = (n * 10000) / cores.length, time = 0, cnt = cores.length;
        while(min <= max) {
            int mid = (min + max) / 2, temp = cores.length;
            for(int i = 0 ; i < cores.length ; i++) temp += mid / cores[i];
            if(temp >= n){
                time = mid; cnt = temp; max = mid - 1;
            } else min = mid + 1;
        }
        int delta = cnt - n;
        for(int i = cores.length - 1 ; i > -1 ; i--){
            if(time % cores[i] == 0) delta--;
            if(delta < 0) {
                answer = i + 1; break;
            }
        }
        
        return answer;
    }
}
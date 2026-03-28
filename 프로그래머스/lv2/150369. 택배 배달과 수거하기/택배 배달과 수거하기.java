class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 5. 중간 처리 가능 시 먼 거리에 있는 집일수록 거리 단축 가능, 
        //    따라서 여유되면 이전 집?들 중 먼 쪽부터 두고오므로 우선해 차감하되,
        //    역순으로 돌며 여유량이 더 먼 집까지 다녀오는 길에 처리하는 수가 유지되어 반영될 수 있게끔 변수 값 유지
        long answer = 0, diliver = 0, pick = 0;
        for(int i = n - 1 ; i >= 0 ; i--) {               // 1. 중간 집 처리하되 먼 집 우선 완료하는 게 가장 빠른데
            long count = 0;                               // 2. 몇번 왕래해야 하느냐
            diliver += deliveries[i]; pick += pickups[i]; // 3. 일단 처리 상자 수 추가하고
            while(diliver > 0 || pick > 0) {              // 4. 수용량 따라서 몇번 갔다 와야 하는지 따지는데
                diliver -= cap; pick -= cap; count++;     // 2-1. 먼 집부터 다 처리하려면 왕래 몇번인지 - while
            }
            answer += (i + 1) * 2 * count;
        }
        return answer;
    }
}
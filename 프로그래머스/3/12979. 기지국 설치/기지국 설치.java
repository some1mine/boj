class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = getNum(1, Math.max(stations[0] - w - 1, 0), w * 2 + 1);
        for(int i = 1 ; i < stations.length ; i++) 
            answer += getNum(stations[i - 1] + w + 1, stations[i] - w - 1, w * 2 + 1);
        answer += getNum(stations[stations.length - 1] + w + 1, n, w * 2 + 1);
        return answer;
    }
    public int getNum(int start, int end, int w) {
        int num = end - start + 1;
        if(num <= 0) return 0;
        return num % w == 0 ? num / w : num / w + 1;
    }
}
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0 ; i < sizes.length ; i += 1) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0]; sizes[i][0] = sizes[i][1]; sizes[i][1] = tmp; 
            }
        }
        int width = 0, height = 0;
        for(int i = 0 ; i < sizes.length ; i += 1) {
            if(sizes[i][0] > width) width = sizes[i][0];
            if(sizes[i][1] > height) height = sizes[i][1];
        }
        answer = width * height;
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++) {
            int length = 0;
            for(int j = 0 ; i - j >= 0 && i + j < arr.length ; j++) {
                if(differ(arr, i - j, i + j)) break;
                length = j * 2 + 1;
            }
            for(int j = i, k = i + 1 ; j >= 0 && k < arr.length ; j--, k++) {
                if(differ(arr, j, k)) break;
                length = Math.max(length, k - j + 1);
            }
            answer = Math.max(answer, length);
        }
        return answer;
    }
    public boolean differ(char[] arr, int a, int b) {
        if(a < 0 && b < arr.length) return true;
        if(a >= 0 && b >= arr.length) return true;
        if(arr[a] != arr[b]) return true;
        return false;
    }
}
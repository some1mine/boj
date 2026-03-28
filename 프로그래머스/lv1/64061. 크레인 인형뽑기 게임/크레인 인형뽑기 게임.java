class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] arr = new int[board.length * board.length]; int ord = 0;
        
        for(int i = 0 ; i < moves.length ; i += 1) { // 크레인 움직임
            for(int j = 0 ; j < board.length ; j += 1) { // 배열 순회
                if(board[j][moves[i] - 1] != 0) {
                    int tmp = 0;
                    for(int k = arr.length - 1 ; k >= 0 ; k -= 1) {
                        if(arr[k] != 0) {
                            tmp = k; break;
                        }
                    }
                    if(board[j][moves[i] - 1] == arr[tmp]) {
                        answer += 2; arr[tmp] = 0; ord -= 1; board[j][moves[i] - 1] = 0; break;
                    } else {
                        arr[ord++] = board[j][moves[i] - 1]; board[j][moves[i] - 1] = 0; break;
                    }
                }
            }
        }
        return answer;
    }
}
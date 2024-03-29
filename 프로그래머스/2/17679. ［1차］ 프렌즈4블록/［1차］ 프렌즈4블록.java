import java.util.*;
import java.awt.Point;

class Solution {
    Set<Point> deleteSet = new HashSet<>();
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        do {
            deleteSet.clear();
            fillDeleteSet(m, n, board);

            answer += deleteSet.size();
            for(Point p : deleteSet) clearBrokenBlocks(n, board, p);
            board = dropAll(board, m, n);
        } while(!deleteSet.isEmpty());
        
        return answer;
    }
    
    public void fillDeleteSet(int m, int n, String[] board) {
        for(int i = 0 ; i < m - 1 ; i++) {
            for(int j = 0 ; j < n - 1 ; j++) {
                if(possible(board, i, j)) {
                    deleteSet.add(new Point(j    , i + 1)); deleteSet.add(new Point(j    , i    ));
                    deleteSet.add(new Point(j + 1, i    )); deleteSet.add(new Point(j + 1, i + 1));
                }
            }
        }
    }
    
    public boolean possible(String[] board, int y, int x) {
        return board[y].charAt(x) != ' '
                && board[y].charAt(x) == board[y].charAt(x + 1)
                && board[y].charAt(x) == board[y + 1].charAt(x)
                && board[y].charAt(x) == board[y + 1].charAt(x + 1);
    }
    
    public void clearBrokenBlocks(int n, String[] board, Point p) {
        board[p.y] = board[p.y].substring(0, p.x) + " " + board[p.y].substring(Math.min(p.x + 1, n));
    }
    
    public String[] dropAll(String[] board, int m, int n) {
        char[][] arr = Arrays.stream(board).map(String::toCharArray).toArray(char[][]::new);
        for(int x = 0 ; x < n ; x++) {
            for(int y = m - 2 ; y >= 0 ; y--) {
                if(arr[y][x] == ' ') continue;
                dropOne(m, arr, x, y);
            }
        }
        return Arrays.stream(arr).map(String::new).toArray(String[]::new);
    }
    
    public void dropOne(int m, char[][] arr, int x, int blockIdx) {
        for(int i = m - 1; i > blockIdx; i--) {
            if(arr[i][x] == ' ') {
                arr[i][x] = arr[blockIdx][x]; arr[blockIdx][x] = ' '; return;
            }
        }
    }
}
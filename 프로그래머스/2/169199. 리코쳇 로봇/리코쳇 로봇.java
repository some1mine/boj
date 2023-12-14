import java.util.*;

class Solution {
    public int solution(String[] board) {
        return bfs(Arrays.stream(board).map(b -> b.toCharArray()).toArray(char[][]::new));
    }
    public int bfs(char[][] board) {
        boolean[][] visitied = new boolean[board.length][board[0].length];
        Block start = null;
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(board[i][j] == 'R') start = new Block(j, i, 0);
            }
        }
        Queue<Block> queue = new LinkedList<>();
        queue.offer(start); visitied[start.y][start.x] = true;
        while(!queue.isEmpty()) {
            Block c = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int[] movedPosition = silde(c, board, i);
                if(board[movedPosition[0]][movedPosition[1]] == 'G') return c.moves + 1;
                if(!visitied[movedPosition[0]][movedPosition[1]]) {
                    queue.offer(new Block(movedPosition[1], movedPosition[0], c.moves + 1));
                    visitied[movedPosition[0]][movedPosition[1]] = true;
                }   
            }
        }
        return -1;
    }
    public int[] silde(Block c, char[][] board, int ord) {
        switch(ord) {
            case 0:
                for(int i = c.y ; i >= 0 ; i--) {
                    if(board[i][c.x] == 'D') return new int[]{i + 1, c.x};
                }
                return new int[]{0, c.x};
            case 1:
                for(int i = c.y ; i < board.length ; i++) {
                    if(board[i][c.x] == 'D') return new int[]{i - 1, c.x};
                }
                return new int[]{board.length - 1, c.x};
            case 2:
                for(int i = c.x ; i >= 0 ; i--) {
                    if(board[c.y][i] == 'D') return new int[]{c.y, i + 1};
                }
                return new int[]{c.y, 0};
            default:
                for(int i = c.x ; i < board[0].length ; i++) {
                    if(board[c.y][i] == 'D') return new int[]{c.y, i - 1};
                }
                return new int[]{c.y, board[0].length - 1};
        }
    }
}

class Block {
    public int x, y, moves;
    public Block(int x, int y, int moves) {
        this.x = x; this.y = y; this.moves = moves;
    }
}
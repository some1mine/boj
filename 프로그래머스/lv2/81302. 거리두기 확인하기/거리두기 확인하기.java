import java.util.*;

class Solution {
    public int[] dirX = {0, -1, 1, 0};
    public int[] dirY = {-1, 0, 0, 1};
    
    public boolean isNextToMan(char[][] room, int x, int y, int exclude) {
        for(int d = 0 ; d < 4 ; d++) {
            if(d == exclude) continue;
            
            int dx = x + dirX[d], dy = y + dirY[d];
            if(dy < 0 || dx < 0 || dy >= room.length || dx >= room[dy].length) continue;
            if(room[dy][dx] == 'P') return true;
        }
        return false;
    }
    
    public boolean isDistanced(char[][] room, int x, int y) {
        for(int d = 0 ; d < 4 ; d++) {
            int dx = x + dirX[d], dy = y + dirY[d];
            if(dy < 0 || dx < 0 || dy >= room.length || dx >= room[dy].length) continue;
            switch(room[dy][dx]) {
                case 'P': 
                    return false;
                case 'O':
                    if(isNextToMan(room, dx, dy, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }
    
    public boolean isDistanced(char[][] room) {
        for(int y = 0 ; y < room.length ; y++) {
            for(int x = 0 ; x < room[y].length ; x++) {
                if(room[y][x] != 'P') continue;
                if(!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0 ; i < answer.length ; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0 ; j < room.length ; j++) room[j] = place[j].toCharArray();
            if(isDistanced(room)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
}
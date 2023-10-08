import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine()); map = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j = 0 ; j < n ; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        long answer = solution(map);
        System.out.print(answer);
    }
    public static long solution(int[][] map) {
        long answer = 0;
        
        answer = divideConquer(0, 0, n - 1, n - 1, true) 
            + divideConquer(0, 0, n - 1, n - 1, false);
        
        if(answer == 0) return -1;
        return answer;
    }
    public static long divideConquer(int startX, int startY, int endX, int endY, boolean isHori) {
        long answer = 0, count = 0; boolean pure = true;
        
        for(int x = startX ; x <= endX ; x++) {
            for(int y = startY ; y <= endY ; y++) {
                if(map[y][x] == 1 && isHori) {
                    if(exists(y, startX, endX, true)) continue;
                    answer += divideConquer(startX, startY, endX, y - 1, false)
                        * divideConquer(startX, y + 1, endX, endY, false);
                    pure = false;
                } else if(map[y][x] == 1) {
                    if(exists(x, startY, endY, false)) continue;
                    answer += divideConquer(startX, startY, x - 1, endY, true)
                        * divideConquer(x + 1, startY, endX, endY, true);
                    pure = false;
                } else if(map[y][x] == 2) count++;
            }
        }
        if(count == 1 && pure) return 1;
        if(pure) return 0;
        
        return answer;
    }
    public static boolean exists(int lineNum, int startNum, int endNum, boolean isHori) {
        if(isHori) {
            for(int i = startNum ; i <= endNum ; i++) {
                if(map[lineNum][i] == 2) return true;
            }
            return false;
        } else {
            for(int i = startNum ; i <= endNum ; i++) {
                if(map[i][lineNum] == 2) return true;
            }
            return false;
        }
    }
}
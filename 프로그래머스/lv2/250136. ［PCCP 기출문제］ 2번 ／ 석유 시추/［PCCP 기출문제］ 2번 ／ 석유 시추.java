import java.util.*;
import java.awt.Point;
 
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    Queue<Point> s = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int[][] idx_map;
    int idx_land = 1; // indexing the rigeon from 1
    
    public int solution(int[][] land) {
        int answer = 0;
        idx_map = new int[land.length][land[0].length];
        
        for(int  x=0 ; x<land[0].length; x++){
            //each column
            HashMap<Integer, Integer> m = new HashMap<>();
            int sum = 0;
            
            for(int y=0; y<land.length; y++){
                //each row
                if(land[y][x] != 0){                
                    if(idx_map[y][x] == 0){
                        // have to find the width
                        // accumulate the sum and and check the Visit flag
                        sum += findWidthbyBFS(x,y, land);
                        m.put(idx_map[y][x], idx_map[y][x]);
                    }else{
                        // already index region
                        if(!m.containsKey(idx_map[y][x])){
                            sum += map.get(idx_map[y][x]);
                            m.put(idx_map[y][x], idx_map[y][x]);
                        }
                    }
                }                
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    // find the width by using BFS
    int findWidthbyBFS(int x, int y, int[][] land){
        s.add(new Point(x,y));
        idx_map[y][x] = idx_land;
        int width = 1;
        
        while(!s.isEmpty()){
            Point p = s.poll();
            int x2 = p.x;
            int y2 = p.y;
            
            for(int m=0; m<4; m++){
                int nx = x2 + dx[m];
                int ny = y2 + dy[m];
                
                if(nx < 0 || ny < 0 || nx >= land[0].length || ny >= land.length || idx_map[ny][nx] != 0 || land[ny][nx] == 0 ) continue;
                
                idx_map[ny][nx] = idx_land;
                land[ny][nx] = ++width;
                s.add(new Point(nx,ny));
            }
        }
        
        //end the finding width
        map.put(idx_land, width);
        idx_land++;
        return width;
    }
}

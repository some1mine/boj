import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        Set<int[][]> resultSet = new HashSet<>(); resultSet.add(key); 
        int[][] key2 = turn(key ); resultSet.add(key2);
        int[][] key3 = turn(key2); resultSet.add(key3); 
        int[][] key4 = turn(key3); resultSet.add(key4); 
        for(int[][] keys : resultSet) {
            if(check(keys, lock)) return true;
        }
        return false;
    }
    public boolean check(int[][] keys, int[][] lock) {
        for(int i = -keys.length ; i < keys.length ; i++) {
            for(int j = -keys[0].length ; j < keys[0].length ; j++) {
                if(open(move(keys, i, j), lock)) return true;
            }
        }
        return false;
    }
    public boolean open(int[][] key, int[][] lock) {
        List<int[]> keyPositions = getPos(key, 1), lockPositions = getPos(lock, 0);
        if(keyPositions.size() != lockPositions.size()) return false;
        for(int i = 1 ; i < keyPositions.size() ; i++) {
            int[] keyPost = keyPositions.get(i - 1), keyCur = keyPositions.get(i),
                  lockPost = lockPositions.get(i - 1), lockCur = lockPositions.get(i);
            if(keyPost[0] - keyCur[0] != lockPost[0] - lockCur[0] || 
               keyPost[1] - keyCur[1] != lockPost[1] - lockCur[1]) return false;
        }
        return true;
    }
    public List<int[]> getPos(int[][] arr, int target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr[0].length ; j++) {
                if(arr[i][j] == target) list.add(new int[]{i, j});
            }
        }
        return list;
    }
    public int[][] move(int[][] key, int y, int x) {
        int[][] result = new int[key.length][key[0].length];
        for(int i = 0 ; i < key.length ; i++) {
            if(i + y < 0 || i + y >= key.length) continue;
            for(int j = 0 ; j < key[0].length ; j++) {
                if(j + x < 0 || j + x >= key[0].length) continue;
                result[i][j] = key[i + y][j + x];
            }
        }
        return result;
    }
    public int[][] turn(int[][] key) {
        int[][] newKey = new int[key[0].length][key.length];
        for(int i = 0 ; i < key[0].length ; i++) {
            for(int j = 0 ; j < key.length ; j++)
                newKey[i][j] = key[j][key[0].length - i - 1];
        }
        return newKey;
    }
}
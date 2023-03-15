import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int m, n;
    public static int[][] field;
    public static int[][] days;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        field = new int[m][m];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < m ; j++) field[i][j] = 1;
        }
        days = new int[n][3];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(reader.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
            days[i][2] = Integer.parseInt(st.nextToken());
        }
        timeFlows();
        for(int[] ar : field) {
            for(int i : ar) System.out.print(i + " ");
            System.out.println();
        }
    }
    private static void timeFlows() {
        for(int i = 0 ; i < days.length ; i++) {
            dayGoes(days[i]);
            oldRemains();
        }
    }
    private static void dayGoes(int[] is) {
        int[] arr = new int[2 * m  - 1];
        for(int i = is[0] ; i < is[0] + is[1] ; i++) arr[i] = 1;
        for(int i = is[0] + is[1] ; i < is[0] + is[1] + is[2] ; i++) arr[i] = 2;
        int idx = 0;
        for(int i = m - 1; i >= 0 ; i--) {
            field[i][0] += arr[idx++];
        }
        for(int i = 1 ; i < m ; i++) {
            field[0][i] += arr[idx++];
        }
    }
    private static void oldRemains() {
        int[][] directions = {{-1, 0}, {0, -1}, {-1, -1}};
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1; j < m ; j++) {
                int max = 0;
                for(int[] direction : directions) {
                    int dx = j + direction[0], dy = i + direction[1];
                    if(field[dy][dx] > max) max = field[dy][dx];
                }
                field[i][j] = max;
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++) arr[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(arr);
        
        int answer = -1;
        /* 최단 거리와 최장 거리 */
        int start = 1, end = arr[n - 1] - arr[0]; 
        
        /* 이분 탐색 */
        while(start <= end) {
            /* 그 중간 */
            int mid = (start + end) / 2; 
            /* 중간을 잡고 그 이상 거리들을 셈 */
            int cnt = 1; int cur = arr[0];
            /* 집 순회 */
            for(int num : arr) {
                /* 거리가 이상이라면 */
                if (num - cur >= mid) { 
                    /* cnt증가, 다음 집으로 갱신 */
                    cnt++; cur = num; 
                }
            }
            /* 타켓 거리 이상 떨어진 거리의 수가 설치할 공유기 수 이상이라면 */
            if (cnt >= c) { 
                /* possible, 거리 더 벌림 */
                answer = mid; start = mid + 1; 
                /* 미만인 경우 impossible, 거리 더 좁힘 */
            } else end = mid - 1; 
        }
        System.out.println(answer);
        reader.close();
    }
}
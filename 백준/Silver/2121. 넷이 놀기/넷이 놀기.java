import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken()),
            height = Integer.parseInt(st.nextToken());
        Set<Dot> dots = new HashSet<>();
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            dots.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int answer = 0;
        for(Dot dot : dots) {
            if(dots.contains(new Dot(dot.x, dot.y + height))
              && dots.contains(new Dot(dot.x + width, dot.y))
               && dots.contains(new Dot(dot.x + width, dot.y + height)))
                answer++;
        }
        System.out.print(answer);
    }
}

class Dot {
    public int x, y;
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        try {
            Dot obj = (Dot) o;
            return this.x == obj.x && this.y == obj.y;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return y * x - y + x;
    }
}
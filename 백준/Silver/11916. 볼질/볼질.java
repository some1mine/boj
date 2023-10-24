import java.util.*;

public class Main {
    public static boolean[] field = new boolean[3];
    public static int answer = 0, bollCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int ball : arr) hitCount(ball);
        System.out.print(answer);
    }

    private static void hitCount(int ball) {
        switch (ball) {
            case 1 : {
                if (++bollCount == 4) go();
                bollCount %= 4;
                break;
            }
            case 2 : {
                go();
                bollCount = 0;
                break;
            }
            default : {
                goFireBall();
                field[0] = ++bollCount == 4;
                bollCount %= 4;
            }
        }
    }

    private static void goFireBall() {
        for (int i = 2; i > 0 ; i--) {
            if (i == 2 && field[i]) {
                answer++; field[i] = false;
            }
            field[i] = field[i - 1];
        }
    }

    private static void go() {
        for (int i = 0; i < 3; i++) {
            if (!field[i]) {
                field[i] = true; break;
            } else if(i == 2) answer++;
        }
    }
}
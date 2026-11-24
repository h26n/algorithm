import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2 * N];
        robots = new boolean[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int turn = 0;
        while (true) {
            turn++;
            rotateBelt();
            moveRobots();
            addRobot();
            if (countZero() >= K) {
                break;
            }
        }

        System.out.println(turn);
    }

    static void rotateBelt() {
        int tmpDurability = arr[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmpDurability;

        boolean tmpRobot = robots[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = tmpRobot;

        robots[N - 1] = false;
    }

    static void moveRobots() {
        // 내리는 위치에서 가까운 로봇부터
        for(int i = N - 2; i >= 0; i--){
            if(robots[i] && !robots[i + 1] && arr[i + 1] > 0) {
                robots[i] = false;
                arr[i + 1]--;
                if(i + 1 < N - 1) robots[i + 1] = true;
            }
        }
    }

    static void addRobot() {
        if(arr[0] > 0) {
            robots[0] = true;
            arr[0]--;
        }
    }

    static int countZero() {
        int count = 0;
        for(int value : arr) {
            if (value == 0) {
                count++;
            }
        }
        return count;
    }
}
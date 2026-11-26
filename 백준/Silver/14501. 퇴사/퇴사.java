import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n + 1];
        int[] pay = new int[n + 1];
        int[] dp = new int[n + 2];

        for (int day = 1; day <= n; day++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[day] = Integer.parseInt(st.nextToken());
            pay[day] = Integer.parseInt(st.nextToken());
        }

        for (int day = 1; day <= n; day++) {
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);
            int nextDay = day + time[day];
            if (nextDay <= n + 1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[day] + pay[day]);
            }
        }

        System.out.println(dp[n + 1]);
    }
}

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp(n);

    }

    static int dp(int n) {
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];

        dp[1] = 0;
        path[1] = 0;

        for (int i = 2; i <= n; i++) {
            //-1 연산 했을때를 미리 저장
            dp[i] = dp[i - 1] + 1;
            //이전 값 미리 저장
            path[i] = i - 1;
            //-1 연산과 나누기 2, 나누기 3 연산 횟수 비교교
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;

            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }
        //최소 연산 출력
        System.out.println(dp[n]);

        //경로 출력
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n).append(" ");
            n = path[n];
        }
        System.out.println(sb.toString());
        return dp[n];
    }
}


import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int count = 0; //토마토가 다 익는 최소 날짜

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); //한 줄 입력받기
        String[] mn = input.split(" "); //공백으로 구분

        int m = Integer.parseInt(mn[0]);//m 입력받은 거 정수로 변환해 저장
        int n = Integer.parseInt(mn[1]);//n 입력받은거 정수로 변환해 저장

        int[][] tomato = new int[n][m]; //토마토 배열 생성
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" "); //한 행 데이터 
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(row[j]);
            }
        }
    }
}

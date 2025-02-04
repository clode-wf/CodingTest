
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, minDistance = Integer.MAX_VALUE;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[][] selected; // 선택된 치킨집 조합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 크기
        M = Integer.parseInt(st.nextToken()); // 유지할 치킨집 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new int[]{i, j});  // 집 저장
                 }else if (value == 2) {
                    chickens.add(new int[]{i, j});  // 치킨집 저장

                            }}
        }

        selected = new int[M][2]; // M개의 치킨집을 선택하는 배열
        combination(0, 0);

        System.out.println(minDistance); // 최소 치킨 거리 출력
    }

    // 치킨집 M개를 선택하는 조합을 구하는 함수 (백트래킹)
    static void combination(int depth, int start) {
        if (depth == M) { // M개를 선택했으면 최소 치킨 거리 계산
            minDistance = Math.min(minDistance, getChickenDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = chickens.get(i); // 치킨집 선택
            combination(depth + 1, i + 1); // 다음 치킨집 선택
        }
    }

    // 현재 선택된 M개의 치킨집에 대한 도시의 치킨 거리 계산
    static int getChickenDistance() {
        int totalDistance = 0;

        for (int[] house : houses) { // 모든 집에 대해 최소 치킨 거리 계산
            int minHouseDistance = Integer.MAX_VALUE;
            for (int[] chicken : selected) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]); // 맨해튼 거리
                minHouseDistance = Math.min(minHouseDistance, distance);
            }
            totalDistance += minHouseDistance; // 도시의 치킨 거리 합산
        }

        return totalDistance;
    }
}

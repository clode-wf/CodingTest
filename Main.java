
import java.io.*;
import java.util.*;

public class Main {

    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            char[][][] building = new char[L][R][C];
            int[] start = new int[3];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = line.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                    }
                }
                br.readLine(); // 빈 줄 처리
            }

            int result = bfs(building, start, L, R, C);
            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
        }
        System.out.print(sb);
    }

    static int bfs(char[][][] building, int[] start, int L, int R, int C) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];

        queue.offer(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0], x = current[1], y = current[2], time = current[3];

            if (building[z][x][y] == 'E') {
                return time;
            }

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C
                        && !visited[nz][nx][ny] && building[nz][nx][ny] != '#') {
                    queue.offer(new int[]{nz, nx, ny, time + 1});
                    visited[nz][nx][ny] = true;
                }
            }
        }
        return -1;
    }
}

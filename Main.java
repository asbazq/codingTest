import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N + 1];
        Arrays.sort(nums);
        dfs(1, new int[M + 1]);

        System.out.print(sb);
    }
    static void dfs(int idx, int[] output) {
        if (idx == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[idx] = nums[i];
                dfs(idx + 1, output);
                visited[i] = false;
            }
        }
    }
}

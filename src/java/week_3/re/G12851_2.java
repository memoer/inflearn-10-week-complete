package week_3.re;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G12851_2 {
  public static void main(String[] args) {
    new Solution().solution();
  }

  private static class Solution {

    private final int[] cnt = new int[100_004]; // 해당 x 좌표까지 가는 데의 경로의 수
    private final int[] path = new int[100_004]; // 해당 x 좌표까지 가는 최단 거리


    public void solution() {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      scanner.nextLine();
      scanner.close();
      if (n == k) {
        System.out.println(0);
        System.out.println(1);
        return;
      }

      Queue<Integer> q = new LinkedList<>();
      cnt[n] = 1;
      path[n] = 1;
      q.offer(n);
      while (!q.isEmpty()) {
        int cur = q.poll();
        int[] nextArr = new int[]{cur - 1, cur + 1, cur * 2};
        for (int next : nextArr) {
          if (!isAvailable(next)) continue;
          if (path[next] == 0) {
            path[next] = path[cur] + 1; // bfs는 가장 처음 만나는 곳이 최단 거리이다.
            cnt[next] += cnt[cur];
            q.offer(next);
          } else if (path[cur] < path[next]) {
            cnt[next] += cnt[cur];
          }
        }
      }
      System.out.println(path[k] - 1);
      System.out.println(cnt[k]);
    }

    private boolean isAvailable(int x) {
      return x >= 0 && x <= 100_000;
    }
  }
}

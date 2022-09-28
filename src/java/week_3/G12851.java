package week_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G12851 {
  public static void main(String[] args) {
    new Solution().solution();
  }

  private static class Solution {
    private int n, k, limit = 100_000;

    private int[] path = new int[100_004];
    private int[] cnt = new int[100_004];

    public void solution() {
      Scanner scanner = new Scanner(System.in);
      n = scanner.nextInt();
      k = scanner.nextInt();
      scanner.nextLine();
      scanner.close();
      if (n == k) {
        System.out.println(0);
        System.out.println(1);
        return;
      }

      Queue<Integer> q = new LinkedList<>();
      path[n] = 1;
      cnt[n] = 1;
      q.add(n);
      while (!q.isEmpty()) {
        int cur = q.poll();
        int[] nArr = {cur - 1, cur + 1, cur * 2};
        for (int next : nArr) {
          if (!isAvailable(next)) continue;
          if (path[next] == 0) {
            path[next] = path[cur] + 1;
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
      return x >= 0 && x <= limit;
    }
  }
}

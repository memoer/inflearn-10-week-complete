package week_3;

import java.util.Arrays;
import java.util.Scanner;

public class P17136 {
  public static void main(String[] args) {
    System.out.println(new Solution().solution());
  }

  private static class Solution {
    int[][] board;
    int n;
    int ans;
    int[] use;

    private int solution() {
      Scanner scanner = new Scanner(System.in);
      ans = Integer.MAX_VALUE;
      n = 10;
      board = new int[n][];
      use = new int[6];
      for (int i = 0; i < n; i++) {
        board[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }
      dfs(0, 0, 0);
      return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int y, int x, int cnt) {
      if (cnt >= ans) return;
      if (x == n) {
        dfs(y + 1, 0, cnt);
        return;
      }
      if (y == n) {
        ans = Integer.min(cnt, ans);
        return;
      }
      if (board[y][x] == 0) {
        dfs(y, x + 1, cnt);
        return;
      }
      for (int size = 5; size > 0; size--) {
        if (use[size] == 5 || !isAvailable(y, x, size)) continue;
        use[size] += 1;
        draw(y, x, size, 0);
        dfs(y, x + size, cnt + 1);
        draw(y, x, size, 1);
        use[size] -= 1;
      }
    }

    private boolean isAvailable(int y, int x, int size) {
      if (y + size > n || x + size > n) return false;
      for (int i = y; i < y + size; i++) for (int j = x; j < x + size; j++) if (board[i][j] == 0) return false;
      return true;
    }

    private void draw(int y, int x, int size, int v) {
      for (int i = y; i < y + size; i++) for (int j = x; j < x + size; j++) board[i][j] = v;
    }
  }
}

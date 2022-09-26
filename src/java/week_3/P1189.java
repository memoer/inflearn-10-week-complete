package week_3;

import java.util.Scanner;

public class P1189 {
  public static void main(String[] args) {
    System.out.println(new Solution().solution());
  }

  private static class Solution {
    private int yLen, xLen, k, ans;
    private String[][] path;
    private int[][] around;

    public int solution() {
      Scanner scanner = new Scanner(System.in);
      yLen = scanner.nextInt();
      xLen = scanner.nextInt();
      k = scanner.nextInt();
      ans = 0;
      scanner.nextLine();
      path = new String[yLen][xLen];
      for (int i = 0; i < yLen; i++) path[i] = scanner.nextLine().split("");
      scanner.close();

      around = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      boolean[][] visited = new boolean[yLen][xLen];
      visited[yLen - 1][0] = true;
      dfs(yLen - 1, 0, 1, visited);
      return ans;
    }

    private void dfs(int y, int x, int acc, boolean[][] visited) {
      if (y == 0 && x == xLen - 1) {
        if (acc == k) ans += 1;
        return;
      }
      for (int[] a : around) {
        int ny = y + a[0];
        int nx = x + a[1];
        if (!isAvailable(ny, nx, visited)) continue;
        visited[y][x] = true;
        dfs(ny, nx, acc + 1, visited);
        visited[y][x] = false;
      }
    }

    private boolean isAvailable(int y, int x, boolean[][] visited) {
      return y >= 0 && x >= 0 && y < yLen && x < xLen && path[y][x].equals(".") && !visited[y][x];
    }
  }
}

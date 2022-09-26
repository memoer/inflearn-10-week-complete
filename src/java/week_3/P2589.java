package week_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P2589 {
  public static void main(String[] args) {
    System.out.println(new Solution().main());
  }

  // L->육지, W->바다, 한 칸 이동하는데 한 시간
  // 보물은 육지에서 움직이는 데에 있어서, 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
  private static class Solution {
    int yLen, xLen, mx;
    String[][] board;
    int[][] visited;
    int[][] around = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 위, 아래, 왼, 오

    public int main() {
      Scanner scanner = new Scanner(System.in);
      yLen = scanner.nextInt();
      xLen = scanner.nextInt();
      scanner.nextLine();

      board = new String[yLen][];
      for (int y = 0; y < yLen; y++) board[y] = scanner.nextLine().split("");

      for (int y = 0; y < yLen; y++)
        for (int x = 0; x < xLen; x++)
          //                    if (board[y][x].equals("L")) bfs(y, x);
          //          if (y == 3 && x == 0) dfs(y, x);
          if (y == 3 && x == 0) {
            boolean[][] visited = new boolean[yLen][xLen];
            visited[y][x] = true;
            dfsRe(y, x, 0, visited);
          }
      return mx - 1;
    }

    private void bfs(int y, int x) {
      visited = new int[yLen][xLen];
      visited[y][x] = 1;
      Queue<int[]> q = new LinkedList<>();
      q.offer(new int[]{y, x});
      while (!q.isEmpty()) {
        int[] poll = q.poll();
        for (int[] arr : around) {
          int ny = poll[0] + arr[0];
          int nx = poll[1] + arr[1];
          if (!isAvailable1(ny, nx, visited)) continue;
          visited[ny][nx] = visited[poll[0]][poll[1]] + 1;
          q.offer(new int[]{ny, nx});
          mx = Integer.max(mx, visited[ny][nx]);
        }
      }
    }

    private void dfs(int y, int x) {
      visited = new int[yLen][xLen];
      visited[y][x] = 1;
      Stack<int[]> stack = new Stack<>();
      stack.push(new int[]{y, x});
      while (!stack.isEmpty()) {
        int[] poll = stack.pop();
        System.out.println(poll[0] + ", " + poll[1]);
        for (int[] arr : around) {
          int ny = poll[0] + arr[0];
          int nx = poll[1] + arr[1];
          if (!isAvailable1(ny, nx, visited)) continue;
          visited[ny][nx] = visited[poll[0]][poll[1]] + 1;
          stack.push(new int[]{ny, nx});
          mx = Integer.max(mx, visited[ny][nx]);
        }
      }
    }

    private void dfsRe(int y, int x, int depth, boolean[][] visited) {
      System.out.println(y + ", " + x);
      for (int[] arr : around) {
        int ny = y + arr[0];
        int nx = x + arr[1];
        if (!isAvailable2(ny, nx, visited)) continue;
        visited[ny][nx] = true;
        dfsRe(ny, nx, depth + 1, visited);
        mx = Integer.max(mx, depth);
      }
    }

    private boolean isAvailable1(int y, int x, int[][] visited) {
      return y >= 0 && x >= 0 && y < yLen && x < xLen && board[y][x].equals("L") && visited[y][x] == 0;
    }

    private boolean isAvailable2(int y, int x, boolean[][] visited) {
      return y >= 0 && x >= 0 && y < yLen && x < xLen && board[y][x].equals("L") && !visited[y][x];
    }
  }
}

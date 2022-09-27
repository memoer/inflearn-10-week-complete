package week_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E12869 {
  public static void main(String[] args) {
    System.out.println(new Solution().solution());
  }

  private static class Solution {
    private final int[][][] visited = new int[64][64][64];
    private final int[][] damage = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
    };

    public int solution() {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      scanner.nextLine();
      int[] arr = new int[3];
      for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

      return solve(arr[0], arr[1], arr[2]);
    }


    private int solve(int a, int b, int c) {
      Queue<Data> q = new LinkedList<>();
      visited[a][b][c] = 1;
      q.add(new Data(a, b, c));
      while (!q.isEmpty() && visited[0][0][0] == 0) {
        Data poll = q.poll();
        for (int[] d : damage) {
          int na = Math.max(0, poll.a - d[0]);
          int nb = Math.max(0, poll.b - d[1]);
          int nc = Math.max(0, poll.c - d[2]);
          if (visited[na][nb][nc] != 0) continue;
          visited[na][nb][nc] = visited[poll.a][poll.b][poll.c] + 1;
          q.add(new Data(na, nb, nc));
        }
      }
      return visited[0][0][0] - 1;
    }

    private static class Data {
      int a, b, c;

      public Data(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
      }
    }
  }
}

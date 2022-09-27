package week_3;

import java.util.*;

public class C16234 {
  public static void main(String[] args) {
    System.out.println(new Solution().solution());
  }

  /**
   * 1. 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
   * 2. 국셩선이 열렸다면, 인구 이동을 시작한다. 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라 한다.
   * 3. 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
   * 4. 연합을 해체하고, 모든 국경선을 닫는다.
   */
  /**
   * 1<=N<=50, 1<=L<=R<=100
   * 인구 이동이 며칠 동안 발생하는 지 반환한다.
   */
  private static class Solution {
    int n, l, r;
    int[][] arr;
    int day = 0;
    int[][] around = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution() {
      Scanner scanner = new Scanner(System.in);
      n = scanner.nextInt();
      l = scanner.nextInt();
      r = scanner.nextInt();
      scanner.nextLine();
      arr = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) arr[i][j] = scanner.nextInt();
        scanner.nextLine();
      }
      scanner.close();

      boolean keepGoing = true;
      while (keepGoing) {
        keepGoing = false;
        boolean[][] visited = new boolean[n][n];
        for (int y = 0; y < n; y++) {
          for (int x = 0; x < n; x++) {
            if (visited[y][x]) continue;
            Union union = bfs(y, x, visited);
            int size = union.list.size();
            if (size == 1) continue;
            for (int[] loc : union.list) arr[loc[0]][loc[1]] = union.sum / size;
            keepGoing = true;
          }
        }
        if (keepGoing) day += 1;
      }

      return day;
    }

    private Union bfs(int y, int x, boolean[][] visited) {
      Union union = new Union();
      Queue<int[]> q = new LinkedList<>();
      visit(new int[]{y, x}, visited, q, union);
      while (!q.isEmpty()) {
        int[] cur = q.poll();
        for (int[] d : around) {
          int[] next = new int[]{cur[0] + d[0], cur[1] + d[1]};
          if (isAvailable(cur, next, visited)) visit(next, visited, q, union);
        }
      }
      return union;
    }

    private boolean isAvailable(int[] cur, int[] next, boolean[][] visited) {
      if (next[0] < 0 || next[1] < 0 || next[0] >= n || next[1] >= n) return false;
      else if (visited[next[0]][next[1]]) return false;
      int diff = Math.abs(arr[cur[0]][cur[1]] - arr[next[0]][next[1]]);
      return diff >= l && diff <= r;
    }

    private void visit(int[] cur, boolean[][] visited, Queue<int[]> q, Union union) {
      visited[cur[0]][cur[1]] = true;
      q.offer(cur);
      union.add(cur, arr[cur[0]][cur[1]]);
    }
    

    private static class Union {
      private final List<int[]> list;
      private int sum;

      public Union() {
        this.list = new ArrayList<>();
        this.sum = 0;
      }

      public void add(int[] loc, int num) {
        list.add(loc);
        this.sum += num;
      }
    }
  }
}

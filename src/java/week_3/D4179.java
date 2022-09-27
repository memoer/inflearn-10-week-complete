package week_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 지훈이와 불은 매 분마다 한 칸씩 수평(or)수직으로 이동한다.
 * 2. 불은 각 지점에서 네 방향으로 확산된다.
 * 3. 지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
 * 4. 지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
 */

/**
 * # -> 벽
 * . -> 지나갈 수 있는 공간
 * J -> 지훈이의 미로 초기 위치
 * F -> 불
 */
// 탈출할 수 있으면 탈출까지의 경로를, 없으면 IMPOSSIBLE을 반환
public class D4179 {
  public static void main(String[] args) {
    int solution = new Solution().solution();
    System.out.println(solution != 0 ? solution : "IMPOSSIBLE");
  }

  private static class Solution {
    int yLen, xLen, ans, sy, sx;
    int[][] fire;
    int[][] path;
    char[][] board;
    int[][] around = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution() {
      Scanner scanner = new Scanner(System.in);
      yLen = scanner.nextInt();
      xLen = scanner.nextInt();
      scanner.nextLine();

      Queue<int[]> q = new LinkedList<>();
      fire = new int[yLen][xLen];
      path = new int[yLen][xLen];
      board = new char[yLen][xLen];

      init();
      for (int i = 0; i < yLen; i++) {
        String[] split = scanner.nextLine().split("");
        for (int j = 0; j < xLen; j++) {
          char ch = split[j].charAt(0);
          board[i][j] = ch;
          if (board[i][j] == 'F') {
            fire[i][j] = 1;
            q.add(new int[]{i, j});
          } else if (board[i][j] == 'J') {
            path[i][j] = 1;
            sy = i;
            sx = j;
          }
        }
      }

      while (!q.isEmpty()) {
        int[] cur = q.poll();
        for (int[] next : around) {
          int ny = cur[0] + next[0];
          int nx = cur[1] + next[1];
          if (!isIn(ny, nx) || board[ny][nx] == '#') continue;
          if (fire[ny][nx] != Integer.MAX_VALUE) continue;
          fire[ny][nx] = fire[cur[0]][cur[1]] + 1;
          q.add(new int[]{ny, nx});
        }
      }

      q.add(new int[]{sy, sx});
      while (!q.isEmpty()) {
        int[] cur = q.poll();
        if (cur[0] == 0 || cur[1] == 0 || cur[0] + 1 == yLen || cur[1] + 1 == xLen) {
          ans = path[cur[0]][cur[1]];
          break;
        }
        for (int[] next : around) {
          int ny = cur[0] + next[0];
          int nx = cur[1] + next[1];
          if (!isIn(ny, nx) || board[ny][nx] == '#') continue;
          if (path[ny][nx] != 0) continue;
          if (path[cur[0]][cur[1]] + 1 >= fire[ny][nx]) continue;
          path[ny][nx] = path[cur[0]][cur[1]] + 1;
          q.add(new int[]{ny, nx});
        }
      }
      return ans;
    }

    private void init() {
      // MAX_VALUE로 초기화하지 않고, 0으로 모두 채울 경우, 아래 반례가 `IMPOSSIBLE` 로 나옴
      //3 3
      //...
      //.J.
      //...
      for (int i = 0; i < yLen; i++) for (int j = 0; j < xLen; j++) fire[i][j] = Integer.MAX_VALUE;
    }

    private boolean isIn(int y, int x) {
      return y >= 0 && x >= 0 && y < yLen && x < xLen;
    }
  }
}

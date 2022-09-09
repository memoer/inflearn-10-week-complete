package week_2.a_2178;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] ipt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[][] board = new int[ipt[0]][ipt[1]];
    for (int i = 0; i < ipt[0]; i++) {
      board[i] = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
    }

    int[][] dist = new int[ipt[0]][ipt[1]];
    int[][] mv = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0});
    dist[0][0] = 1;
    while (!q.isEmpty()) {
      int[] poll = q.poll();
      for (int[] coord : mv) {
        int ny = poll[0] + coord[0];
        int nx = poll[1] + coord[1];
        if (ny < 0 || ny >= ipt[0] || nx < 0 || nx >= ipt[1] || board[ny][nx] == 0) {
          continue;
        }
        if (dist[ny][nx] != 0) {
          continue;
        }
        dist[ny][nx] = dist[poll[0]][poll[1]] + 1;
        q.offer(new int[]{ny, nx});
      }
    }
    System.out.println(dist[ipt[0] - 1][ipt[1] - 1]);
  }
}

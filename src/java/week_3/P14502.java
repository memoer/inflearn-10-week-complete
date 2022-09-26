package week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * **문제풀 때, 1-2시간 고민할 것. 그 이상으로 넘어가면 풀이를 보는 게 낫다.**
 * 1. 최소/최대 범위 확인
 * 2. 시간 복잡도 파악하는 것이 제일 중요.
 * - 시간 복잡도 파악 후, "(A)무식하게 풀지, (B)효율적으로 풀지" 를 선택한다.
 * 3. 반례 확인 중요
 */

public class P14502 {
  public static void main(String[] args) throws IOException {
    System.out.println(new Solution().solution());
  }

  private static class Solution {
    private int[][] board;
    private int yLen;
    private int xLen;
    private int[][] around;

    public int solution() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      this.around = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      this.yLen = Integer.parseInt(st.nextToken());
      this.xLen = Integer.parseInt(st.nextToken());
      this.board = new int[yLen][xLen];
      List<int[]> wallList = new ArrayList<>();
      List<int[]> virusList = new ArrayList<>();
      int ans = Integer.MIN_VALUE;
      for (int i = 0; i < yLen; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < xLen; j++) {
          int v = Integer.parseInt(st.nextToken());
          if (v == 0) wallList.add(new int[]{i, j});
          else if (v == 2) virusList.add(new int[]{i, j});
          board[i][j] = v;
        }
      }
      br.close();

      int size = wallList.size();
      // 64개 중, 3개를 선택 -> 반복문 횟수 -> [64]C[3]
      for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
          for (int k = j + 1; k < size; k++) {
            int[][] copy = copy(yLen, xLen);
            copy[wallList.get(i)[0]][wallList.get(i)[1]] = 1;
            copy[wallList.get(j)[0]][wallList.get(j)[1]] = 1;
            copy[wallList.get(k)[0]][wallList.get(k)[1]] = 1;
            for (int[] virus : virusList) search(virus[0], virus[1], copy); // 바이러스 최대 10개
            ans = Math.max(ans, calculate(copy)); // 64
          }
        }
      }
      // [64]C[3] * ( 10K + 64 )

      return ans;
    }

    private void search(int y, int x, int[][] arr) {
      for (int[] ints : around) {
        int ny = y + ints[0];
        int nx = x + ints[1];
        if (!isAvailable(ny, nx, arr)) continue;
        arr[ny][nx] = 2;
        search(ny, nx, arr);
      }
    }

    private boolean isAvailable(int y, int x, int[][] arr) {
      if (y < 0 || x < 0 || y >= yLen || x >= xLen) return false;
      return arr[y][x] == 0;
    }

    private int[][] copy(int yLen, int xLen) {
      int[][] ret = new int[yLen][xLen];
      for (int i = 0; i < yLen; i++) {
        for (int j = 0; j < xLen; j++) {
          ret[i][j] = board[i][j];
        }
      }
      return ret;
    }

    private int calculate(int[][] arr) {
      int sum = 0;
      for (int[] ints : arr) {
        for (int anInt : ints) {
          if (anInt == 0) sum += 1;
        }
      }
      return sum;
    }
  }
}

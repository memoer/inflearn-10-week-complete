package week_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P17825 {
  public static void main(String[] args) {
    new Solution().solution();
  }

  private static class Solution {
    private int[] score;
    private List<Integer>[] path;
    private int[] input;
    private int[] mal;

    private void solution() {
      Scanner scanner = new Scanner(System.in);
      input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      scanner.close();

      init();
      System.out.println(search(0));
    }

    private int search(int acc) {
      if (acc == 10) return 0;
      int ret = 0;
      for (int i = 0; i < 4; i++) {
        int tmpIdx = mal[i];
        int malIdx = move(mal[i], input[acc]);
        if (isMal(malIdx, i)) continue;
        mal[i] = malIdx;
        ret = Integer.max(ret, search(acc + 1) + (malIdx == -1 ? 0 : score[malIdx]));
        mal[i] = tmpIdx;
      }
      return ret;
    }

    private boolean isMal(int there, int which) {
      if (there == -1) return false;
      for (int i = 0; i < 4; i++) {
        if (i == which) continue;
        if (mal[i] == there) return true;
      }
      return false;
    }

    private int move(int here, int cnt) {
      if (here == -1) return -1;
      else if (path[here].size() >= 2) {
        here = path[here].get(1);
        cnt -= 1;
      }
      while (cnt-- > 0 && here != -1) here = path[here].get(0);
      return here;
    }

    private void init() {
      mal = new int[4];
      score = new int[32];
      for (int i = 1; i < 21; i++) score[i] = i * 2;
      for (int i = 21; i < 24; i++) score[i] = 10 + ((i - 20) * 3);
      for (int i = 24; i < 26; i++) score[i] = 22 + ((i - 24) * 2);
      for (int i = 26; i < 29; i++) score[i] = 28 - (i - 26);
      for (int i = 29; i < 32; i++) score[i] = 25 + ((i - 29) * 5);
      path = new ArrayList[32];
      for (int i = 0; i < 32; i++) path[i] = new ArrayList<>();
      for (int i = 0; i < 20; i++) path[i].add(i + 1);
      path[20].add(-1);

      path[5].add(21);
      path[21].add(22);
      path[22].add(23);
      path[23].add(29);

      path[10].add(24);
      path[24].add(25);
      path[25].add(29);

      path[15].add(26);
      path[26].add(27);
      path[27].add(28);
      path[28].add(29);

      path[29].add(30);
      path[30].add(31);
      path[31].add(20);
    }
  }
}

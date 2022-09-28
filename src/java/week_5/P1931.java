package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] timeArr = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      timeArr[i][0] = Integer.parseInt(split[0]);
      timeArr[i][1] = Integer.parseInt(split[1]);
    }
    br.close();

    Arrays.sort(timeArr, Comparator.comparingInt((int[] p) -> p[1]).thenComparingInt(p -> p[0]));
    /**
     * 종료 시간이 같을 때, 시작 시간을 빠른 순서대로 정렬하는 이유
     * "1 3 -> 8 8 -> 4 8" 은 ans가 3이되어야 하지만, 시작 시간을 빠른 순서대로 정렬하지 않을 경우 2가 된다.
     * "8 8"에서 preEnd가 8이 되고 -> "4 8"에서 "8 > 4"조건이 true가 되기 때문에 -> continue를 통해 ans가 누적되지 않는다.
     */
    int ans = 1;
    int preEnd = timeArr[0][1];
    for (int i = 1; i < n; i++) {
      if (preEnd > timeArr[i][0]) continue;
      preEnd = timeArr[i][1];
      ans += 1;
    }
    System.out.println(ans);
  }
}

package week_5.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D14469_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    br.close();

    // NlogN
    Arrays.sort(arr, Comparator.comparingInt(p -> p[0]));
    int seconds = arr[0][0] + arr[0][1];
    // N
    for (int i = 1; i < n; i++) {
      seconds = Integer.max(seconds, arr[i][0]);
      seconds += arr[i][1];
    }
    // O(NlogN)
    System.out.println(seconds);
  }
}

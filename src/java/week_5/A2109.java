package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A2109 {
  /**
   * 0<=n<10,000
   * 1<=d<=10,000
   * 1<=p<=10,000
   */
  /**
   * 하루에 한 곳만 가능
   * 가장 많이 돈을 벌 수 있도록 강연 -> 번 돈을 반환
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      arr[i] = new int[]{d, p};
      max = Integer.max(max, d);
    }
    br.close();

    int ans = 0;
    Arrays.sort(arr, (p, c) -> Integer.compare(c[0], p[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int day = max, i = 0; day > 0; day--) {
      while (i < n && arr[i][0] >= day) pq.offer(arr[i++][1]);
      if (!pq.isEmpty()) ans += pq.poll();
    }
    System.out.println(ans);
  }
}

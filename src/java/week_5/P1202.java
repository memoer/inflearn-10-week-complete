package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202 {
  /**
   * N -> 보석 개수, M -> 보석 무게, V -> 보석 가격
   * K -> 가방 개수, C -> 가방 무게
   */
  /**
   * 1<=N, K<=300,000
   * 0<=M,V<=1,000,000
   * 1<=C<=100,000,000
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] a = new int[n][2];
    int[] b = new int[k];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i][0] = Integer.parseInt(st.nextToken());
      a[i][1] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      b[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    Arrays.sort(a, Comparator.comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
    Arrays.sort(b);

    int j = 0;
    long ans = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < k; i++) {
      while (j < n && a[j][0] <= b[i]) pq.offer(a[j++][1]);
      if (!pq.isEmpty()) ans += pq.poll();
    }

    System.out.println(ans);
  }
}

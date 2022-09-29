package week_5.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] jArr = new int[n][2];
    int[] bArr = new int[k];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      jArr[i][0] = Integer.parseInt(st.nextToken());
      jArr[i][1] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < k; i++) bArr[i] = Integer.parseInt(br.readLine());
    br.close();

    Arrays.sort(jArr, Comparator.comparingInt(p -> p[0]));
    Arrays.sort(bArr);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    long ans = 0;
    for (int i = 0, j = 0; i < k; i++) {
      while (j < n && jArr[j][0] <= bArr[i]) pq.offer(jArr[j++][1]);
      if (!pq.isEmpty()) ans += pq.poll();
    }
    System.out.println(ans);
  }
}

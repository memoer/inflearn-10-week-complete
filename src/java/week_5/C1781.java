package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C1781 {
  // 1<=N<=200,000
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

    Arrays.sort(arr, Comparator.comparingInt(p -> p[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.offer(arr[i][1]);
      if (pq.size() > arr[i][0]) pq.poll();
    }
    int ans = 0;
    while (!pq.isEmpty()) ans += pq.poll();
    System.out.println(ans);
  }
}

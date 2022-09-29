package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D14469 {
  /**
   * 두 소가 동시에 검문을 받을 수 없다.
   * - 한 소가 5초에 도착 7초 동안 검문 받으면 -> 8초에 도착한 소는 12초까지 줄을 서야 검문을 받을 수 있다.
   */
  /**
   * 1 <= N <= 100
   * 1 <= v <= 1,000,000
   */
  // 모든 소가 농장에 입장하는 데 걸리는 최소 시간을 출력한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
    // NlogN
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
    }
    br.close();

    int seconds = 0;
    // NlogN
    while (!pq.isEmpty()) {
      int[] poll = pq.poll();
      while (poll[0] > seconds) seconds += 1;
      //      if (poll[0] > seconds) seconds = poll[0];
      seconds += poll[1];
    }
    // O(NlogN)
    System.out.println(seconds);
  }
}

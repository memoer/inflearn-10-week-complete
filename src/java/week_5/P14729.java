package week_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P14729 {
  /**
   * 8<=N<=10,000,000
   * O(NlogN) 로 해결해야 하는 문제입니다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < n; i++) {
      double score = Double.parseDouble(br.readLine());
      pq.offer(score);
      if (pq.size() > 7) pq.poll();
    }
    br.close();

    ArrayList<Double> ans = new ArrayList<>();
    while (!pq.isEmpty()) ans.add(pq.poll());
    for (int i = 6; i >= 0; i--) bw.write(String.format("%.3f\n", ans.get(i)));
    bw.flush();
    bw.close();
  }
}

package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * KeyPoint -> 수열의 길이가 만들 수 있는 집합의 개수다.
 * 12345 -> 1,12,123,1234,12345 총 5개의 집합을 만들 수 있다.
 * 1234 -> 1,12,123,1234 총 4개의 집합을 만들 수 있다.
 * 167 -> 1,16,167 총 3개의 집합을 만들 수 있다.
 */
public class H13144 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    br.close();

    boolean[] visited = new boolean[100_001];
    long ans = 0;
    for (int s = 0, e = 0; s < n; s++) {
      while (e < n && !visited[arr[e]]) {
        visited[arr[e]] = true;
        e += 1;
      }
      ans += (e - s);
      visited[arr[s]] = false;
    }
    System.out.println(ans);
  }
}

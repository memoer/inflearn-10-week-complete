package week_5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class I3273 {
  // 1 <= n <= 100,000
  // 1 <= a <= 1,000,000
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(scanner.nextLine());
    for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(scanner.nextLine());
    scanner.close();
    Arrays.sort(arr);

    int left = 0, right = n - 1, ans = 0;
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (sum <= x) {
        left += 1;
        if (sum == x) ans += 1;
      } else {
        right -= 1;
      }
    }
    System.out.println(ans);
  }
}

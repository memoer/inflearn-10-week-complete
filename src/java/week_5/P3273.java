package week_5;

import java.util.Arrays;
import java.util.Scanner;

// 투포인터
public class P3273 {
  /**
   * 1<=n<=100,000
   * 1<=v<=1,000,000
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    int x = Integer.parseInt(scanner.nextLine());
    scanner.close();

    int ans = 0;
    int left = 0;
    int right = n - 1;
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (sum > x) {
        right -= 1;
      } else {
        left += 1;
        if (sum == x) ans += 1;
      }
    }
    System.out.println(ans);
  }
}

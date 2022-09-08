package week_1.h_2559;

import java.util.Scanner;

public class Main {

  /**
   * 2 <= N <= 100,000 1 <= K <= N
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] s = scanner.nextLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);
    int[] arr = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = scanner.nextInt();
      arr[i] += arr[i - 1];
    }

    int answer = Integer.MIN_VALUE;
    for (int i = k; i <= n; i++) {
      int v = arr[i] - arr[i - k];
      answer = Integer.max(answer, v);
    }
    System.out.println(answer);
  }
}

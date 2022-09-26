package week_3;

import java.util.Scanner;

public class P1436 {
  public static void main(String[] args) {
    new Solution().solution();
  }

  private static class Solution {
    public void solution() {
      Scanner scanner = new Scanner(System.in);
      int n = Integer.parseInt(scanner.nextLine());
      int i = 666;
      for (; ; i++) {
        if (String.valueOf(i).contains("666")) n--;
        if (n == 0) break;
      }
      System.out.println(i);
    }
  }
}

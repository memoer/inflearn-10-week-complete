package week_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F16637 {
  public static void main(String[] args) {
    System.out.println(new Solution().solution());
  }

  private static class Solution {
    List<Integer> numList = new ArrayList<>();
    List<Character> operList = new ArrayList<>();
    int ans;

    public int solution() {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      scanner.nextLine();
      String s = scanner.nextLine();

      for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        if (i % 2 == 0) numList.add(ch - '0');
        else operList.add(ch);
      }
      ans = Integer.MIN_VALUE;
      search(0, numList.get(0));
      return ans;
    }

    private int calculate(char ch, int a, int b) {
      switch (ch) {
        case '+':
          return a + b;
        case '-':
          return a - b;
        case '*':
          return a * b;
        default:
          throw new UnsupportedOperationException();
      }
    }

    // 1+2 -> 2,1
    // 1+2+3 -> 3,2
    private void search(int idx, int sum) {
      if (idx == numList.size() - 1) {
        ans = Math.max(ans, sum);
        return;
      }
      search(idx + 1, calculate(operList.get(idx), sum, numList.get(idx + 1)));

      if (idx + 2 < numList.size()) {
        int tmp = calculate(operList.get(idx + 1), numList.get(idx + 1), numList.get(idx + 2));
        search(idx + 2, calculate(operList.get(idx), sum, tmp));
      }
    }
  }
}

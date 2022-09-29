package week_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G1644 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    scanner.close();
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i <= n; i++) if (isPrime(i)) list.add(i);

    int size = list.size();
    int ans = 0;
    int left = 0;
    int right = 0;
    int sum = 0;
    while (left < size) {
      if (sum == n) {
        ans += 1;
        sum -= list.get(left++);
      } else if (sum > n) {
        sum -= list.get(left++);
      } else {
        if (right == size) break;
        else sum += list.get(right++);
      }
    }
    System.out.println(ans);
  }

  private static boolean isPrime(int n) {
    int end = (int) Math.sqrt(n);
    for (int i = 2; i <= end; i++) if (n % i == 0) return false;
    return true;
  }
}

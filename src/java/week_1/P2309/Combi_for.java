package week_1.P2309;

import java.util.Arrays;
import java.util.Scanner;

public class Combi_for {

  private static void check(int sum, int[] arr) {
    for (int i = 0; i < 9; i++) {
      int a = arr[i];
      for (int j = i + 1; j < 9; j++) {
        int b = arr[j];
        if (sum - (a + b) == 100) {
          arr[i] = -1;
          arr[j] = -1;
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[9];
    int sum = 0;

    for (int i = 0; i < 9; i++) {
      arr[i] = scanner.nextInt();
      sum += arr[i];
    }
    scanner.close();

    check(sum, arr);
    Arrays.sort(arr);
    for (int i = 2; i < 9; i++) {
      System.out.println(arr[i]);
    }
  }
}

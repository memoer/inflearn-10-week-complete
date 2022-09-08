package week_1.a_2309;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Combi_recur {

  private static final int LIMIT = 9;

  private static int[] arr;

  private static int sum;

  private static Deque<Integer> s;

  private static void result(int start, int acc) {
    if (s.size() == 2) {
      if (sum - acc == 100) {
        print();
        System.exit(0);
      }
      return;
    }
    for (int i = start; i < LIMIT; i++) {
      s.push(i);
      result(i + 1, acc + arr[i]);
      s.pop();
    }
  }

  private static void print() {
    arr[s.pop()] = -1;
    arr[s.pop()] = -1;
    Arrays.sort(arr);
    for (int v : arr) {
      if(v == -1) continue;
      System.out.println(v);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    arr = new int[LIMIT];
    sum = 0;
    s = new ArrayDeque<>();
    for (int i = 0; i < LIMIT; i++) {
      arr[i] = scanner.nextInt();
      sum += arr[i];
    }
    scanner.close();

    result(0, 0);
  }
}

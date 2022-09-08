package week_1.c_2979;

import java.util.Scanner;

public class Main {

  private static int a, b, c;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    a = scanner.nextInt();
    b = scanner.nextInt();
    c = scanner.nextInt();
    scanner.nextLine();

    int[] t1 = new int[2];
    int[] t2 = new int[2];
    int[] t3 = new int[2];
    for (int i = 0; i < 3; i++) {
      switch (i) {
        case 0:
          t1[0] = scanner.nextInt();
          t1[1] = scanner.nextInt();
          break;
        case 1:
          t2[0] = scanner.nextInt();
          t2[1] = scanner.nextInt();
          break;
        case 2:
          t3[0] = scanner.nextInt();
          t3[1] = scanner.nextInt();
          break;
      }
    }
    scanner.close();

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < 2; i++) {
      min = Integer.min(t1[0], Integer.min(t2[0], t3[0]));
      max = Integer.max(t1[1], Integer.max(t2[1], t3[1]));
    }

    int sum = 0;
    for (int i = min; i < max; i++) {
      int acc = 0;
      if (isParked(t1, i)) acc += 1;
      if (isParked(t2, i)) acc += 1;
      if (isParked(t3, i)) acc += 1;
      sum += getFee(acc);
    }
    System.out.println(sum);
  }

  private static boolean isParked(int[] t, int i) {
    return t[0] <= i && t[1] > i;
  }

  private static int getFee(int acc) {
    switch(acc){
      case 1: return a;
      case 2: return b*2;
      case 3: return c*3;
      default: return 0;
    }
  }
}

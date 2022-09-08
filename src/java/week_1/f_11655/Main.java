package week_1.f_11655;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] s = scanner.nextLine().toCharArray();
    scanner.close();

    for (char c : s) {
      if (!Character.isAlphabetic(c)) {
        System.out.print(c);
        continue;
      }
      int e = c + 13;
      if (Character.isUpperCase(c)) {
        if (e > 90) e = e-26;
      } else if (e > 122) e = e-26;
      System.out.print((char)e);
    }
  }
}

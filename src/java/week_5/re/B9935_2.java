package week_5.re;

import java.util.Scanner;

public class B9935_2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] s = scanner.nextLine().toCharArray();
    String t = scanner.nextLine();
    scanner.close();

    StringBuilder sb = new StringBuilder();
    for (char ch : s) {
      sb.append(ch);
      int len = sb.length();
      int start = len - t.length();
      if (len >= t.length() && sb.substring(start, len).equals(t)) sb.delete(start, len);
    }
    if (sb.length() == 0) System.out.println("FRULA");
    else System.out.println(sb);
  }
}

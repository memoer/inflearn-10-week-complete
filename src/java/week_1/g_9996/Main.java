package week_1.g_9996;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    String p = scanner.nextLine();

    int pos = p.indexOf("*");
    String p_pre = p.substring(0, pos);
    String p_suf = p.substring(pos + 1);

    for (int i = 0; i < n; i++) {
      String s = scanner.nextLine();
      if (p_pre.length() + p_suf.length() > s.length()) {
        System.out.println("NE");
        continue;
      }

      String s_pre = s.substring(0, pos);
      String s_suf = s.substring(s.length() - p_suf.length());
      if (p_pre.equals(s_pre) && p_suf.equals(s_suf)) {
        System.out.println("DA");
      } else {
        System.out.println("NE");
      }
    }
    scanner.close();
  }
}

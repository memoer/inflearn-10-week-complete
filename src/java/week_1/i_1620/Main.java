package week_1.i_1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] s = scanner.nextLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);

    Map<String, Integer> map1 = new HashMap<>();
    Map<Integer, String> map2 = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String p = scanner.nextLine();
      map1.put(p, i);
      map2.put(i, p);
    }
    for (int i = 0; i < m; i++) {
      String q = scanner.nextLine();
      try {
        int v = Integer.parseInt(q);
        System.out.println(map2.get(v));
      } catch (NumberFormatException ne) {
        System.out.println(map1.get(q));
      }
    }
    scanner.close();
  }
}

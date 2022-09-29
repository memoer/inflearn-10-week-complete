package week_5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B9935 {
  /**
   * 모든 폭발이 끝난 후, 어떤 문자열이 남는지 반환
   * - 남아있는 문자가 없을 경우, FRULA 반환
   * - 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
   */
  /**
   * 1 <= s <= 1,000,000
   * 1 <= k <= 36
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] cArr = scanner.nextLine().toCharArray();
    String k = scanner.nextLine();
    scanner.close();

    int len = cArr.length;
    int check = k.length() - 1;
    char last = k.charAt(check);
    Deque<Character> dq = new ArrayDeque<>();
    for (int i = 0; i < len; i++) {
      char ch = cArr[i];
      if (ch != last) {
        dq.addFirst(ch);
        continue;
      }
      boolean isMatch = true;
      StringBuilder sb = new StringBuilder();
      if (dq.size() < check) isMatch = false;
      else {
        for (int t = 0; t < check; t++) {
          char poll = dq.pollFirst();
          sb.append(poll);
          if (poll != k.charAt(check - 1 - t)) {
            isMatch = false;
            break;
          }
        }
      }
      if (!isMatch) {
        for (int t = sb.length() - 1; t >= 0; t--) dq.addFirst(sb.charAt(t));
        dq.addFirst(ch);
      }
    }
    if (dq.isEmpty()) System.out.println("FRULA");
    else {
      StringBuilder sb = new StringBuilder();
      while (!dq.isEmpty()) sb.append(dq.pollLast());
      System.out.println(sb);
    }
  }
}

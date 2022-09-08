package week_1.e_1159;

import java.util.Scanner;

/**
 * 1. 고민 -> 1~2 시간
 * 2. 문제 풀이
 *    1. 최소/최대 범위 확인
 *    2. 일단 무식하게 푼다. 중요한 건 시간 복잡도 파악
 *      - 단순 구현이라면, 반례 파악
 *    3. 시간복잡도가 안되거나, 단순 구현이 아니라면, 다른 알고리즘 생각
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 처음부터 풀기 [처음 볼 때 30분 내로 풀 수 있을 정도로]
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    int[] arr = new int[26];
    for (int i = 0; i < n; i++) {
      char f = scanner.nextLine().charAt(0);
      arr[f - 97] += 1;
    }
    scanner.close();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if(arr[i] < 5)continue;
      sb.append((char)(i + 97));
    }
    if(sb.length() == 0) sb.append("PREDAJA");
    System.out.println(sb.toString());
  }
}

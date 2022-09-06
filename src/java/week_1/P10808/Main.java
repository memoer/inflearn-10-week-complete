package week_1.P10808;

import java.util.Scanner;

/**
 * 1. 고민 -> 1~2시간 1. 최소/최대 범위 확인 2. 일단 무식하게 푼다. 중요한 건 시간복잡도 파악 - 구현 문제라면 반례 확인 3. 시간복잡도 내에 안되거나, 구현 문제가 아니라면, 다른 알고리즘 생각
 * 2. 문제 풀이 3. 답지 확인 - 틀리면, 해당 문제 일주일 내내 처음부터 다시 풀기 [처음 보자마자 30분 내로 풀 수 있을 정도로]
 */
public class Main {

  // 문자열 S -> 길이: 100, 소문자로만
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] chars = scanner.nextLine().toCharArray();
    scanner.close();

    int[] arr = new int[26];
    for (char ch : chars) {
      arr[(int) ch - 97] += 1;
    }
    for (int v : arr) System.out.print(v+" ");
  }
}

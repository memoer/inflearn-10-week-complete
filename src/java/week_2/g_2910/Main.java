package week_2.g_2910;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Map<Integer, Data> map = new HashMap<>();
    int idx = 0;
    for (int i = 0; i < input[0]; i++) {
      int v = scanner.nextInt();
      if (!map.containsKey(v)) {
        map.put(v, new Data(idx++));
      } else {
        map.get(v).addCnt();
      }
    }

    map.entrySet().stream().sorted((a, b) -> {
      Data pre = a.getValue();
      Data cur = b.getValue();
      return pre.cnt != cur.cnt ? Integer.compare(cur.cnt, pre.cnt) : Integer.compare(pre.idx, cur.idx);
    }).forEach(e -> {
      int cnt = e.getValue().cnt;
      for (int i = 0; i < cnt; i++) {
        System.out.print(e.getKey() + " ");
      }
    });
  }

  private static class Data {

    int idx;

    int cnt;

    public Data(int idx) {
      this.idx = idx;
      cnt = 1;
    }

    public void addCnt() {
      this.cnt += 1;
    }
  }
}

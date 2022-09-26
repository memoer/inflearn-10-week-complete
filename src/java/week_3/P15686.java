package week_3;

import java.util.*;

public class P15686 {
  public static void main(String[] args) {
    System.out.println(new Solution().solution());
  }

  /**
   * 0->빈 칸, 1->집, 2->치킨 집
   * 치킨 집 중, M개만 남겨 놓는다.
   * M개만 남겨놓을 시, 각 집에서 치킨 집까지 거리의 모든 합이 최소인 값을 반환하시오.
   */
  private static class Solution {
    private int n;
    private int m;
    private List<int[]> chickenList;
    private List<int[]> homeList;
    private List<Set<int[]>> candidateList;
    private boolean[] visited;
    private int ans;

    public int solution() {
      Scanner scanner = new Scanner(System.in);
      n = scanner.nextInt();
      m = scanner.nextInt();
      scanner.nextLine();

      chickenList = new ArrayList<>();
      homeList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int j = 0; j < n; j++) {
          if (array[j] == 2) chickenList.add(new int[]{i, j});
          else if (array[j] == 1) homeList.add(new int[]{i, j});
        }
      }
      scanner.close();

      candidateList = new ArrayList<>();
      combination(chickenList.size(), 0, new HashSet<>());

      this.visited = new boolean[homeList.size()];
      ans = Integer.MAX_VALUE;
      for (Set<int[]> cSet : candidateList) {
        int ret = 0;
        for (int[] home : homeList) {
          int min = Integer.MAX_VALUE;
          for (int[] chicken : cSet) min = Integer.min(min, getDist(home, chicken));
          ret += min;
        }
        ans = Integer.min(ans, ret);
      }

      return ans;
    }

    private void combination(int n, int start, Set<int[]> set) {
      int size = set.size();
      if (size == m) {
        candidateList.add(new HashSet<>(set));
        return;
      }
      for (int i = start; i < n; i++) {
        int[] arr = chickenList.get(i);
        set.add(arr);
        combination(n, i + 1, set);
        set.remove(arr);
      }
    }

    private int getDist(int[] home, int[] chicken) {
      return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
    }
  }
}

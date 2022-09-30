package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class J1700 {
  private static int n, k, ans = 0;
  private static int[] order;
  private static boolean[] used;
  private static List<Integer> usedObjectList;

  /**
   * 멀티탭 구멍 개수 -> 1<=N<=100
   * 전기 용품 총 사용횟수 -> 1<=K<=100
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    order = new int[k];
    used = new boolean[k + 1];
    usedObjectList = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) order[i] = Integer.parseInt(st.nextToken());
    br.close();

    for (int i = 0; i < k; i++) {
      int object = order[i];
      if (used[object]) continue;
      else if (usedObjectList.size() == n) {
        eject(i + 1);
        ans += 1;
      }
      use(object);
    }
    System.out.println(ans);
  }

  private static void eject(int s) {
    // 현재 콘센트를 모두 사용하고 있고, 사용하려는 기기가 콘센트를 사용하고 있지 않았을 때 들어온다.
    int lastIdx = 0, targetObject = 0;
    // 콘센트를 사용하고 있는 기기 첫 번째부터 차례대로 돈다.
    for (int usedObject : usedObjectList) {
      int curIdx = Integer.MAX_VALUE;
      // 사용하려는 기기의 다음 기기부터 반복문을 차례대로 돈다.
      for (int i = s; i < k; i++) {
        // 콘센트를 사용하고 있는 기기가 뒤에서 또 존재할 경우, break;를 건다.
        if (usedObject == order[i]) {
          curIdx = i;
          break;
        }
      }
      // 뒤에서 또 존재했던 콘센트가 이전의 선택되었던[lastIdx]보다 그 뒤에 있다면, 해당 기기를 target으로 삼는다.
      // 즉, 콘센트를 사용하고 있는 기기중, 가-장 뒤에서 또 사용되는 걸 target으로 삼는다.
      // Greedy -> 뒤의 기기들중, 현재 사용하고 있는 기기가 최단기간내로 또 사용될 것들은 내버려둔다. 한-참 뒤에 사용될 것을 뺀다.
      if (lastIdx < curIdx) {
        lastIdx = curIdx;
        targetObject = usedObject;
      }
    }
    unuse(targetObject);
  }

  private static void unuse(int object) {
    usedObjectList.remove((Integer) object);
    used[object] = false;
  }

  private static void use(int object) {
    usedObjectList.add(object);
    used[object] = true;
  }
}

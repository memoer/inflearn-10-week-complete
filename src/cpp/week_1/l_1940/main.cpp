#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
/**
 * 1. 고민 -> 1~2시간
 * 2. 풀이
 *    1. 최소/최대 범위 확인
 *    2. 일단 무식하게 푼다. 중요한 건 시간 복잡도 파악
 *      - 반례 파악 중요
 *    3. 시간 복잡도가 안되거나, 단순 구현이 아니라면, 다른 알고리즘 생각
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 복기 [처음 볼 때 30분 내로 풀 수 있을 정도로]
 */

// 첫째줄 N -> 재료의 개수 N [1 <= N <= 15,000]
// 두째줄 M -> 갑옷을 만드는데 필요한 수 M [1 <= M <= 10,000,000]
// 세째줄 U -> N개의 재료들이 가진 고유한 번호들 [1 <= U <= 100,000]
/**
 * 두 재료의 고유한 번호들을 합쳐서 M이 되면 갑옷이 만들어진다.
 * 총 몇개의 갑옷을 만들 수 있는가?
 */
int n, m, ret, u[15001];

// O(N^2)
void combi(int u[], int sum, int start, int depth) {
  if (depth == 2) {
    if (sum == m) ret += 1;
    return;
  }
  // 첫 번째 호출 -> O(N)
  // 두 번째 호출 -> O(kN)
  for (int i = start; i < n; i++) {
    combi(u, sum + u[i], i + 1, depth + 1);
  }
}
// O(N^2) -> 225,000,000
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> m;
  if (m > 200000) {
    cout << 0 << '\n';
  } else {
    for (int i = 0; i < n; i++) cin >> u[i];
    combi(u, 0, 0, 0);
    cout << ret << '\n';
  }

  return 0;
}
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

/**
 * 1. 고민 -> 1~2시간
 *    1. 최소/최대 범위 확인
 *    2. 일단 무식하게 푼다. 중요한 건 시간 복잡도 파악
 *      - 구현 문제라면, 반례 확인
 *    3. 시간 복잡도가 안되거나, 구현 문제가 아니면, 다른 알고리즘 생각
 * 2. 문제 풀이
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 처음부터 풀기 [처음 볼 때, 30분 내로 풀수 있을 정도로]
 */
/**
 * 한 대 -> 1분에 한 대당 A 원
 * 두 대 -> 1분에 한 대당 B 원
 * 세 대 -> 1분에 한 대당 C 원
 */
/** 최대/최소 범위 확인
 * 1 <= C <= B <= A <= 100
 */
int a, b, c, m1 = INT_MAX, m2 = INT_MIN, sum;
int t1[2], t2[2], t3[2];

bool isParked(int t[], int i) { return t[0] <= i && t[1] > i; }

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> a >> b >> c;
  for (int i = 0; i < 3; i++) {
    int j, k;
    cin >> j >> k;
    m1 = min(m1, j);
    m2 = max(m2, k);
    switch (i) {
      case 0:
        t1[0] = j;
        t1[1] = k;
        break;
      case 1:
        t2[0] = j;
        t2[1] = k;
        break;
      case 2:
        t3[0] = j;
        t3[1] = k;
        break;
    }
  }

  for (int i = m1; i < m2; i++) {
    int acc = 0;
    if (isParked(t1, i)) acc += 1;
    if (isParked(t2, i)) acc += 1;
    if (isParked(t3, i)) acc += 1;
    switch (acc) {
      case 1:
        sum += a;
        break;
      case 2:
        sum += (b * 2);
        break;
      case 3:
        sum += (c * 3);
        break;
    }
  }
  cout << sum << '\n';
  return 0;
}

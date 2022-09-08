#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
/**
 * 1. 고민 -> 1~2 시간
 * 2. 문제 풀이
 *    1. 최소/최대 범위 확인
 *    2. 일단 무식하게 푼다. 중요한 건 시간 복잡도 파악
 *      - 단순 구현이라면, 반례 확인
 *    3. 시간 복잡도가 안되거나, 단순 구현이 아니라면, 다른 알고리즘 사용
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 복기 [처음 볼 때 30분 내로 풀 수 있을 정도로 ]
 */

/**
 * 1 <= n <= 100
 * 1 <= s.length <= 100
 */
int n;
string s, pre_s, suf_s, f;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> s;
  int pos = s.find('*');
  pre_s = s.substr(0, pos);
  suf_s = s.substr(pos + 1);

  for (int i = 0; i < n; i++) {
    cin >> f;
    if (pre_s.size() + suf_s.size() > f.size()) {
      cout << "NE\n";
    } else {
      if (pre_s == f.substr(0, pre_s.size()) && suf_s == f.substr(f.size() - suf_s.size()))
        cout << "DA\n";
      else
        cout << "NE\n";
    }
  }

  return 0;
}
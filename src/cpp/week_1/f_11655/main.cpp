#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

/**
 * 1. 고민 -> 1~2시간
 * 2. 문제 풀이
 *    1. 최소/최대 범위 확인
 *    2. 일단 무식하게 푼다. 중요한 건 시간 복잡도 파악
 *      - 단순 구현이라면 반례 파악
 *    3. 시간 복잡도가 안되거나, 단순 구현이 아니라면, 다른 알고리즘 생각
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 확인. [처음 볼 때 30분 내로 풀 수 있을 정도로]
 */

string s, result;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  getline(cin, s);
  for (char ch : s) {
    if (!isupper(ch) && !islower(ch)) {
      result += ch;
      continue;
    }
    int a = ch + 13;
    if (isupper(ch) && a > 90) {
      a = a - 90 + 64;
    } else if (islower(ch) && a > 122) {
      a = a - 122 + 96;
    }
    result += (char)a;
  }
  cout << result << '\n';

  return 0;
}
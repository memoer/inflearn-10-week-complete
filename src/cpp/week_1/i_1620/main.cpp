#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

/**
 * 1. 고민 -> 1~2시간
 * 2. 풀이
 *    1. 최소/최대 범위 확인
 *    2. 일단 무식하게 풀기. 중요한 건 시간복잡도 파악
 *      - 반례 파악 중요
 *    3. 시간 복잡도가 안되거나, 단순 구현으로 안될 경우, 다른 알고리즘 생각
 * 3. 답지 확인
 *    - 틀렸으면, 일주일 내내 처음부터 다시 풀기 [처음 볼 때 30분 내로 풀 수 있을 정도로]
 */

/**
 * 1. N -> 포켓몬의 개수, M -> 내가 맞춰야 하는 개수
 *    - 1 <= N,M <= 100,000
 * 2. 둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력
 *    - 첫 글자만 대문자, 나머지는 소문자S
 *    - 2 <= 문자열 길이 <= 20
 * 3. 그 다음줄부터 총 M개의 줄에 내가 맞춰야 하는 문제가 입력
 *    - 문자열 입력이면, 문자열에 해당하는 번호 출력
 *    - 숫자로만 들어오면, 번호에 해당하는 문자 출력
 */
int n, m;
map<string, int> m1;
map<int, string> m2;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    string s;
    cin >> s;
    m1[s] = i;
    m2[i] = s;
  }

  for (int i = 0; i < m; i++) {
    string s;
    cin >> s;
    int idx = atoi(s.c_str());
    if (idx == 0) {
      // 문자열
      cout << to_string(m1[s]) << '\n';
    } else {
      cout << m2[idx] << '\n';
    }
  }

  return 0;
}
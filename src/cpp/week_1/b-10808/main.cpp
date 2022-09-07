#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
/**
 1. 고민 -> 1~2시간
    1. 최소, 최대 범위 확인
    2. 일단 무식하게 풀기. 제일 중요한 건 시간 복잡도 파악
        - 단순 구현이라면, 반례 확인할 것
    3. 시간 복잡도 내에 안되거나 (or) 단순 구현 문제가 아니라면, 다른 알고리즘 생각
 2. 문제 풀이
 3. 답지 확인
    - 틀리면, 해당 문제 일주일 내내 처음부터 풀어볼 것 [처음 보자마자 30분 내에 풀 수 있을 정도로]
 */

/**
 * 최소, 최대 범위
 * 문자열 S -> 단어의 길이는 100을 넘지 않음, 소문자로 구성
 */
int cnt[26];
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> s;
  for (char c : s) cnt[c - 'a'] += 1;
  for (int n : cnt) cout << n << " ";

  return 0;
}
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

string s, ret;
char mid;
int cnt[100], flag;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> s;
  for (char ch : s) cnt[(int)ch] += 1;

  for (int i = 'Z'; i >= 'A'; i--) {
    if (!cnt[i]) continue;
    if (cnt[i] & 1) {  // 홀수이면
      mid = char(i);
      flag += 1;
      cnt[i] -= 1;  // 짝수로 다시 만든다.
    }
    if (flag == 2) break;
    for (int j = 0; j < cnt[i]; j += 2) {
      // cnt[i]가 0이면, 위에서 걸러진다.
      // cnt[i]가 홀수이면, 짝수로 변경된다.
      // cnt[i]가 짝수이면, 해당 글자를 양 옆으로 붙여줘야 한다. [2개씩 감소해주어야 함]
      ret = char(i) + ret + char(i);
    }
  }

  if (mid) ret.insert(ret.begin() + ret.size() / 2, mid);
  if (flag == 2)  // 홀수 개수가 2개이면 팰린드롬이 되지 않음
    cout << "I'm Sorry Hansoo\n";
  else
    cout << ret << '\n';

  return 0;
}
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, ret;
string s;

// 1 <= N[단어의 수] <= 100
// 2 < s[i].length < 100,000 [모든 단어 길이의 합은 1,000,000을 넘지 않는다.]
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n;

  for (int i = 0; i < n; i++) {
    stack<char> stk;
    cin >> s;
    for (char ch : s) {
      if (!stk.empty() && stk.top() == ch)
        stk.pop();
      else
        stk.push(ch);
    }
    if (stk.empty()) ret += 1;
  }

  cout << ret << '\n';
  return 0;
}
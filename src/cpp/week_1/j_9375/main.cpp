#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int t, n;
string a, b;

/**
 * 0 <= n <= 30
 */

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> t;
  while (t-- > 0) {
    map<string, int> mp;
    cin >> n;
    for (int j = 0; j < n; j++) {
      cin >> a >> b;
      mp[b] += 1;
    }
    int ret = 1;
    for (auto e : mp) {
      // headgear -> hat, turban이 있으면 한 개씩 선택하는 경우의 수(=2) + 아예 선택하지 않는 경우의 수(=1) -> 3
      ret *= (e.second + 1);
    }
    ret -= 1;
    cout << ret << '\n';
  }

  return 0;
}
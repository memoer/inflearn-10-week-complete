#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n, m, ret, u[15001];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> u[i];

  if (m > 200000) {
    cout << 0 << '\n';
  } else {
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (u[i] + u[j] == m) ret += 1;
      }
    }
    cout << ret << '\n';
  }

  return 0;
}
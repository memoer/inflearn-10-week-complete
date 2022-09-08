#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int a, b, c, m, n, cnt[101], sum;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> a >> b >> c;
  for (int i = 0; i < 3; i++) {
    cin >> m >> n;
    for (int j = m; j < n; j++) {
      cnt[j] += 1;
    }
  }

  for (int i = 1; i < 100; i++) {
    switch (cnt[i]) {
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
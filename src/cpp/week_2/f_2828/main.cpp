#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, m, j, l, r, temp, ret;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> m >> j;

  l = 1;
  while (j-- > 0) {
    cin >> temp;
    r = l + m - 1;
    if (temp >= l && temp <= r) {
      continue;
    } else if (temp > r) {
      ret += (temp - r);
      l += (temp - r);
    } else {
      ret += (l - temp);
      l = temp;
    }
  }

  cout << ret << '\n';

  return 0;
}
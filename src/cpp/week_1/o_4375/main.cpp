#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  while (cin >> n) {
    int cnt = 1;
    int rest = 0;
    int v = 1;

    while ((rest = v % n) != 0) {
      // 7%1, 7%11, 7%41, 7%61, ... ->
      v = rest * 10 + 1;
      cnt += 1;
    }

    // while (v % n != 0) {
    //   // 7%1, 7%11, 7%111, 7%1111, ... ->
    //   v = v * 10 + 1;
    //   cnt += 1;
    // }

    cout << cnt << '\n';
  }

  return 0;
}
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int y, x;
vector<int[]> perm;

void permutation(int n, int r, int start, int arr[], int acc) {
  if (r == acc) {
    perm.add(arr);
    return;
  }
  for (int i = start; i < n; i++) {
    arr[r] = i;
    permutation(n, r, start + 1, arr, acc + 1);
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> y >> x;
  vector<int[]> vt;
  int arr[y][x];
  for (int i = 0; i < y; i++) {
    for (int j = 0; j < x; j++) {
      cin >> arr[i][j];
      if (arr[i][j] == 2) vt.push_back({i, j});
    }
  }

  // permutation(y * x, vt.size(), 0, int[vt.size()], 0);

  return 0;
}

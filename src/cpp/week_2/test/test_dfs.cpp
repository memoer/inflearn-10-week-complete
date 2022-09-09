#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n, m;
bool board[101][101];
pair<int, int> pr[] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

void dfs(int y, int x) {
  board[y][x] = false;
  for (pair<int, int> t : pr) {
    int k = y + t.first;
    if (k >= 0 && k < n && board[k][x]) dfs(k, x);
    int l = x + t.second;
    if (l >= 0 && l < m && board[y][l]) dfs(y, l);
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> m;

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) cin >> board[i][j];
  }

  int cnt = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (!board[i][j]) continue;
      dfs(i, j);
      cnt += 1;
    }
  }
  cout << cnt << '\n';

  return 0;
}
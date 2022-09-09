#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int m, n, k, cnt;
bool board[100][100];
vector<int> ans;
vector<pair<int, int>> mv = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

void check() {
  int ax, ay, bx, by;
  cin >> ax >> ay >> bx >> by;
  for (int y = ay; y < by; y++) {
    for (int x = ax; x < bx; x++) board[y][x] = true;
  }
}
void dfs(int y, int x) {
  board[y][x] = true;
  cnt += 1;
  for (pair<int, int> p : mv) {
    int adjY = y + p.first;
    int adjX = x + p.second;
    if (adjY < 0 || adjX < 0 || adjY >= m || adjX >= n) continue;
    if (board[adjY][adjX]) continue;
    dfs(adjY, adjX);
  }
}
void printAns() {
  cout << ans.size() << '\n';
  sort(ans.begin(), ans.end());
  for (int v : ans) cout << v << " ";
  cout << '\n';
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> m >> n >> k;
  for (int i = 0; i < k; i++) check();

  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (board[i][j]) continue;
      cnt = 0;
      dfs(i, j);
      ans.push_back(cnt);
    }
  }

  printAns();
  return 0;
}
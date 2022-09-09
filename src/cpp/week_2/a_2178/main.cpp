#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n, m, dist[100][100];
bool board[100][100];
string s;
pair<int, int> p[] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) scanf("%1d", &board[i][j]);
  }

  queue<pair<int, int>> q;
  dist[0][0] = 1;
  q.push({0, 0});
  while (!q.empty()) {
    pair<int, int> cur = q.front();
    q.pop();
    for (pair<int, int> adj : p) {
      int ny = cur.first + adj.first;
      int nx = cur.second + adj.second;
      if (ny < 0 || ny >= n || nx < 0 || nx >= m || !board[ny][nx]) continue;
      if (dist[ny][nx]) continue;
      dist[ny][nx] = dist[cur.first][cur.second] + 1;
      q.push({ny, nx});
    }
  }

  cout << dist[n - 1][m - 1] << '\n';

  return 0;
}
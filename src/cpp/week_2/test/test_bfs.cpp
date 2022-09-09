#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int y, x, my, mx, ty, tx;
bool board[101][101];
int dist[101][101];
pair<int, int> mv[] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

bool isVisited(int y, int x) { return !dist[y][x]; }

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //

  cin >> y >> x >> my >> mx >> ty >> tx;
  for (int i = 0; i < y; i++)
    for (int j = 0; j < x; j++) cin >> board[i][j];

  queue<pair<int, int>> q;
  q.push({my, mx});
  dist[my][mx] = 1;
  while (!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    for (pair<int, int> adj : mv) {
      int ny = p.first + adj.first;
      int nx = p.second + adj.second;
      if (ny < 0 || ny >= y || nx < 0 || nx >= x || board[ny][nx] == 0) continue;
      if (dist[ny][nx]) continue;
      dist[ny][nx] = dist[p.first][p.second] + 1;
      q.push({ny, nx});
    }
  }
  cout << dist[ty][tx] << '\n';

  return 0;
}
// 5 5
// 0 0
// 4 4
// 1 0 1 0 1
// 1 1 1 0 1
// 0 0 1 1 1
// 0 0 1 1 1
// 0 0 1 1 1
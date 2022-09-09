#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n, ret = 1;
int board[101][101];
bool visited[101][101];
pair<int, int> p[] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

void bfs(int sy, int sx, int d) {
  queue<pair<int, int>> q;
  q.push({sy, sx});
  visited[sy][sx] = true;
  while (!q.empty()) {
    pair<int, int> cur = q.front();
    q.pop();
    for (pair<int, int> adj : p) {
      int ny = cur.first + adj.first;
      int nx = cur.second + adj.second;
      if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] <= d) continue;
      if (visited[ny][nx]) continue;
      visited[ny][nx] = true;
      q.push({ny, nx});
    }
  }
}

// 2<= n <= 100
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> board[i][j];
    }
  }

  for (int d = 1; d < 101; d++) {
    int cnt = 0;
    fill(&visited[0][0], &visited[0][0] + 101 * 101, false);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] <= d || visited[i][j]) continue;
        bfs(i, j, d);
        cnt += 1;
      }
    }
    ret = max(ret, cnt);
  }

  cout << ret << '\n';

  return 0;
}
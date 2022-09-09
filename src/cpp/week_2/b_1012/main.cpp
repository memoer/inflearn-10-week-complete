#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int t, w, h, k, y, x, cnt;
bool board[50][50];
pair<int, int> mv[] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

void bfs(int sy, int sx) {
  queue<pair<int, int>> q;
  q.push({sy, sx});
  board[sy][sx] = false;
  while (!q.empty()) {
    pair<int, int> cur = q.front();
    q.pop();
    for (pair<int, int> adj : mv) {
      int ny = cur.first + adj.first;
      int nx = cur.second + adj.second;
      if (ny < 0 || ny >= h || nx < 0 || nx >= w || !board[ny][nx]) continue;
      board[ny][nx] = false;
      q.push({ny, nx});
    }
  }
}

// 1 <= w <= 50, 가로 길이
// 1 <= h <= 50, 세로 길이
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> t;
  while (t-- > 0) {
    fill(&board[0][0], &board[0][0] + 50 * 50, false);
    cnt = 0;
    cin >> w >> h >> k;
    for (int i = 0; i < k; i++) {
      cin >> x >> y;
      board[y][x] = true;
    }
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (!board[i][j]) continue;
        bfs(i, j);
        cnt += 1;
      }
    }
    cout << cnt << '\n';
  }

  return 0;
}
